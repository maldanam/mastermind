package org.mastermind.codemaker.repository;

import org.mastermind.codemaker.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
	

}
