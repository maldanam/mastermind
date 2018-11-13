package org.mastermind.board.repository;

import org.mastermind.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
	

}
