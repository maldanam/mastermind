package org.mastermind.board.service;

import java.util.Optional;

import org.mastermind.board.dto.GameDto;
import org.mastermind.board.exception.GameNotFoundException;
import org.mastermind.board.repository.GameRepository;
import org.mastermind.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	private final GameRepository gameRepository;

	@Autowired
	public BoardService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public GameDto gameDetails(Integer gameId) throws GameNotFoundException {
		
		Optional<Game> currentGame = gameRepository.findById(gameId);
		if (!currentGame.isPresent()) {
			throw new GameNotFoundException();
		}
		
		GameDto result = new GameDto(currentGame.get());
				
		return result;
	}

}
