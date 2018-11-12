package org.mastermind.codemaker.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mastermind.codemaker.dto.GuessResultDto;
import org.mastermind.codemaker.model.Game;
import org.mastermind.codemaker.model.Pattern;
import org.mastermind.codemaker.model.CodePegEnum;
import org.mastermind.codemaker.model.factory.GameFactory;
import org.mastermind.codemaker.repository.GameRepository;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CodemakerServiceTest {

	CodemakerService service;
	
	@Mock
	GameRepository gameRepo;
	
	@Before
	public void setUp() throws Exception {
		service = new CodemakerService(gameRepo);
	}

	@Test
	public void testAllBlack() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.GREEN, CodePegEnum.BLUE, CodePegEnum.RED);
		
		assertTrue(guessResult.getNumBlacks().equals(4));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testAllWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.GREEN, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(4));
	}

	@Test
	public void testZeroBlackZeroWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.YELLOW, CodePegEnum.BROWN, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testOneBlackZeroWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(1));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testZeroBlackOneWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.YELLOW, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(1));
	}

	@Test
	public void testOneBlackOneWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(1));
		assertTrue(guessResult.getNumWhites().equals(1));
	}

	@Test
	public void testTwoBlackZeroWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.RED);
		
		assertTrue(guessResult.getNumBlacks().equals(2));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testZeroBlackTwoWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.YELLOW, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(2));
	}

	@Test
	public void testOneBlackTwoWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.BLUE, CodePegEnum.GREEN, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(1));
		assertTrue(guessResult.getNumWhites().equals(2));
	}

	@Test
	public void testTwoBlackOneWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BLUE, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(2));
		assertTrue(guessResult.getNumWhites().equals(1));
	}

	@Test
	public void testTwoBlackTwoWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.BLUE, CodePegEnum.GREEN, CodePegEnum.RED);
		
		assertTrue(guessResult.getNumBlacks().equals(2));
		assertTrue(guessResult.getNumWhites().equals(2));
	}

	@Test
	public void testThreeBlackZeroWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.GREEN, CodePegEnum.BLUE, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(3));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testZeroBlackThreeWhite() {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.BLUE, CodePegEnum.RED, CodePegEnum.GREEN, CodePegEnum.BROWN);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(3));
	}

	private Game getMockGameRedGreenBlueRed() {
		
		Game result = GameFactory.create();
		
		Pattern fixedPattern = new Pattern(CodePegEnum.RED, CodePegEnum.GREEN, CodePegEnum.BLUE, CodePegEnum.RED);
		
		result.setPattern(fixedPattern);
		
		return result;
	}
}
