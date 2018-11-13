package org.mastermind.codemaker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mastermind.codemaker.dto.GameDto;
import org.mastermind.codemaker.dto.GuessResultDto;
import org.mastermind.codemaker.exception.GameEndedException;
import org.mastermind.codemaker.exception.GameNotFoundException;
import org.mastermind.codemaker.model.factory.GameFactory;
import org.mastermind.codemaker.repository.GameRepository;
import org.mastermind.codemaker.repository.TurnRepository;
import org.mastermind.model.CodePegEnum;
import org.mastermind.model.Game;
import org.mastermind.model.GameStatusEnum;
import org.mastermind.model.Guess;
import org.mastermind.model.GuessResult;
import org.mastermind.model.KeyPegEnum;
import org.mastermind.model.Pattern;
import org.mastermind.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodemakerService {

	private final GameRepository gameRepository;
	private final TurnRepository turnRepository;

	@Autowired
	public CodemakerService(GameRepository gameRepository, TurnRepository turnRepository) {
		this.gameRepository = gameRepository;
		this.turnRepository = turnRepository;
	}
	
	public GameDto newGame() {
		
		Game aGame = GameFactory.create();
		
		gameRepository.save(aGame);
		
		GameDto result = new GameDto(aGame);
		
		result.setConfiguration(GameFactory.getCurrentConfig());
		
		return result;
	}

	public GuessResultDto guess(Integer gameId, 
			CodePegEnum color1,
			CodePegEnum color2,
			CodePegEnum color3,
			CodePegEnum color4) throws Exception {
		
		Optional<Game> currentGame = gameRepository.findById(gameId);
		if (!currentGame.isPresent()) {
			throw new GameNotFoundException();
		}
		
		if (currentGame.get().getStatus().equals(GameStatusEnum.ENDED)) {
			throw new GameEndedException();
		}
		
		Guess guess = new Guess(color1, color2, color3, color4);
		GuessResult guessResult = evaluateGuess(currentGame.get(), new CodePegEnum[] { color1, color2, color3, color4 });
				
		Turn currentTurn = new Turn(guess, guessResult);
		turnRepository.save(currentTurn);
		
		currentGame.get().addTurn(currentTurn);
		
		gameRepository.save(currentGame.get());
		
		return new GuessResultDto(guessResult);
	}
	
	private GuessResult evaluateGuess(Game aGame, CodePegEnum[] guess) {
		
		Pattern p = aGame.getPattern();
		
		List<CodePegEnum> codePegs = new ArrayList<>(Arrays.asList(p.getColor1(), p.getColor2(), p.getColor3(), p.getColor4() ));
		
		KeyPegEnum[] keyPegs = new KeyPegEnum[4];
		
		// Set BLACKs
		for (int i=0; i < guess.length; i++) {
			if (guess[i].equals(codePegs.get(i))) {
				keyPegs[i] = KeyPegEnum.BLACK;
				codePegs.set(i, null);
			}
		}
		
		// Set WHITEs
		for (int i=0; i < guess.length; i++) {
			if ( ! KeyPegEnum.BLACK.equals(keyPegs[i])) {
				if (codePegs.contains(guess[i])) {
					keyPegs[i] = KeyPegEnum.WHITE;
					codePegs.set(codePegs.indexOf(guess[i]), null);
				}
			}
		}		
		
		return new GuessResult(keyPegs);
	}
}
