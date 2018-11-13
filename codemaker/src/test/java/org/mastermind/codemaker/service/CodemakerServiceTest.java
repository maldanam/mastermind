package org.mastermind.codemaker.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mastermind.codemaker.dto.GuessResultDto;
import org.mastermind.codemaker.model.factory.GameFactory;
import org.mastermind.codemaker.repository.GameRepository;
import org.mastermind.codemaker.repository.TurnRepository;
import org.mastermind.model.CodePegEnum;
import org.mastermind.model.Game;
import org.mastermind.model.Pattern;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CodemakerServiceTest {

	CodemakerService service;
	
	@Mock
	GameRepository gameRepo;
	
	@Mock
	TurnRepository turnRepo;
	
	@Before
	public void setUp() throws Exception {
		service = new CodemakerService(gameRepo, turnRepo);
	}

	@Test
	public void testAllBlack() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.GREEN, CodePegEnum.BLUE, CodePegEnum.RED);
		
		assertTrue(guessResult.getNumBlacks().equals(4));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testAllWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.GREEN, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(4));
	}

	@Test
	public void testZeroBlackZeroWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.YELLOW, CodePegEnum.BROWN, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testOneBlackZeroWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(1));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testZeroBlackOneWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.YELLOW, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(1));
	}

	@Test
	public void testOneBlackOneWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(1));
		assertTrue(guessResult.getNumWhites().equals(1));
	}

	@Test
	public void testTwoBlackZeroWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.RED);
		
		assertTrue(guessResult.getNumBlacks().equals(2));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testZeroBlackTwoWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.YELLOW, CodePegEnum.RED, CodePegEnum.BROWN, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(0));
		assertTrue(guessResult.getNumWhites().equals(2));
	}

	@Test
	public void testOneBlackTwoWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.BLUE, CodePegEnum.GREEN, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(1));
		assertTrue(guessResult.getNumWhites().equals(2));
	}

	@Test
	public void testTwoBlackOneWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.RED, CodePegEnum.BLUE, CodePegEnum.YELLOW);
		
		assertTrue(guessResult.getNumBlacks().equals(2));
		assertTrue(guessResult.getNumWhites().equals(1));
	}

	@Test
	public void testTwoBlackTwoWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.BLUE, CodePegEnum.GREEN, CodePegEnum.RED);
		
		assertTrue(guessResult.getNumBlacks().equals(2));
		assertTrue(guessResult.getNumWhites().equals(2));
	}

	@Test
	public void testThreeBlackZeroWhite() throws Exception {
		
		Game mockGame = getMockGameRedGreenBlueRed();
		
		when( gameRepo.findById(1) ).thenReturn( Optional.of( mockGame ) );
		
		GuessResultDto guessResult = service.guess(1, CodePegEnum.RED, CodePegEnum.GREEN, CodePegEnum.BLUE, CodePegEnum.BLUE);
		
		assertTrue(guessResult.getNumBlacks().equals(3));
		assertTrue(guessResult.getNumWhites().equals(0));
	}

	@Test
	public void testZeroBlackThreeWhite() throws Exception {
		
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
