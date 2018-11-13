package org.mastermind.board.controller;

import org.mastermind.board.dto.GameDto;
import org.mastermind.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/board/game") 
public class BoardController {
	
	private final BoardService service;

	@Autowired 	
	public BoardController(BoardService theService) {
		this.service = theService;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody GameDto viewGameBoard(@PathVariable Integer id) throws Exception {
		
		return service.gameDetails(id);
	}

}
