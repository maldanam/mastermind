package org.mastermind.codemaker.controller;

import org.mastermind.codemaker.dto.GameDto;
import org.mastermind.codemaker.service.CodemakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/codemaker/games") 
public class CodemakerController {
	
	private final CodemakerService service;

	@Autowired 	
	public CodemakerController(CodemakerService theService) {
		this.service = theService;
	}
	
	@GetMapping(path="/new")
	public @ResponseBody GameDto createNewGame() {
		return service.newGame();
	}

}
