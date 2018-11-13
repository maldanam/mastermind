package org.mastermind.codemaker.controller;

import org.mastermind.codemaker.dto.GameDto;
import org.mastermind.codemaker.dto.GuessResultDto;
import org.mastermind.codemaker.service.CodemakerService;
import org.mastermind.model.CodePegEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(path="/{id}/guess")
	public @ResponseBody GuessResultDto makeGuess(@PathVariable Integer id,
										   		  @RequestParam CodePegEnum color1,
										   		  @RequestParam CodePegEnum color2,
										   		  @RequestParam CodePegEnum color3,
										   		  @RequestParam CodePegEnum color4) throws Exception {
		
		return service.guess(id, color1, color2, color3, color4);
	}

}
