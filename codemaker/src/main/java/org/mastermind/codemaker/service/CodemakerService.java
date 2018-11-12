package org.mastermind.codemaker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.mastermind.codemaker.dto.GameDto;
import org.mastermind.codemaker.dto.GuessResultDto;
import org.mastermind.codemaker.model.CodePegEnum;
import org.mastermind.codemaker.model.Game;
import org.mastermind.codemaker.model.GuessResult;
import org.mastermind.codemaker.model.KeyPegEnum;
import org.mastermind.codemaker.model.Pattern;
import org.mastermind.codemaker.model.factory.GameFactory;
import org.mastermind.codemaker.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodemakerService {

	private final GameRepository gameRepository;

	@Autowired
	public CodemakerService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
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
			CodePegEnum color4) {
		
		Optional<Game> currentGame = gameRepository.findById(gameId);
		if (!currentGame.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		return new GuessResultDto(evaluateGuess(currentGame.get(), new CodePegEnum[] { color1, color2, color3, color4 }));
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
