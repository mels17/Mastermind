package test;

import main.Constants;
import main.Game;
import main.Mastermind;
import main.UserInputValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class IntegratedTest {

    List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

    Mastermind mastermind;
    Constants constants;
    Game game;
    UserInputValidation userInputValidation;

    public int getNumberOfWhites(List<String> result) {
        int noOfWhites = 0;
        for( String res: result ) {
            if (res.equals("Black")) {
                noOfWhites++;
            }
        }
        return noOfWhites;
    }

    public String getColourNotInMastermind(List<String> mastermindColours) {
        for (String colour: constants.allPossibleColours) {
            if(!mastermindColours.contains(colour)) {
                return colour;
            }
        }
        return "";
    }

    @Before
    public void initializeAllObjects() {
        constants = new Constants();
        mastermind = new Mastermind(constants);
        userInputValidation = new UserInputValidation(constants);
        game = new Game(constants, userInputValidation);
    }


    @Test
    public void givenAllCorrectUserInputGetResultAsArrayWithWonMessage() {
        mastermind.setSelectedColours(true);

        game.setUsersGuess(mastermind.getSelectedColours());

        Assert.assertEquals("WON", mastermind.mastermind(game).get(0));
    }

    @Test
    public void givenOneAnswerExpectShuffledListOfResults() {
        List<String> expectedResult = Arrays.asList("White", "White", "White", "White");
        mastermind.setSelectedColours(true);

        List<String> mastermindColours = mastermind.getSelectedColours();

        String colour = getColourNotInMastermind(mastermindColours);

        List<String> userInput = Arrays.asList(colour, colour, colour, colour);

        game.setUsersGuess(userInput);

        Assert.assertEquals(expectedResult, mastermind.mastermind(game));
    }

    @Test
    public void givenOneCorrectRestWrongGetOneBlackRestWhite() {
        mastermind.setSelectedColours(true);

        List<String> mastermindColours = mastermind.getSelectedColours();

        String colour = getColourNotInMastermind(mastermindColours);

        List<String> userInput = Arrays.asList(mastermindColours.get(0), colour, colour, colour);

        game.setUsersGuess(userInput);

        Assert.assertEquals(1, getNumberOfWhites(mastermind.mastermind(game)));
    }

    @Test
    public void returnNullErrorIfUserInputNotSet() {
        mastermind.setSelectedColours(true);
        try{
            mastermind.mastermind(game);
        } catch (Error e) {
            Assert.assertEquals("Error: User guess not initialized.", e.getMessage());
        }
    }

    @Test
    public void returnErrorIfUserInputLengthIsInvalid() {
        mastermind.setSelectedColours(true);

        try{
            game.setUsersGuess(Arrays.asList("Green"));
        } catch (Error e) {
            Assert.assertEquals("Error: you must pass 4 colours!", e.getMessage());
        }
    }

    @Test
    public void returnErrorIfColourIsNotInTheListOfAllPossibleColours() {
        mastermind.setSelectedColours(true);
        try{
            game.setUsersGuess(Arrays.asList("Green", "Pink", "Purple", "Yellow"));
        } catch (Error e) {
            Assert.assertEquals("Error: you have given an invalid colour!", e.getMessage());
        }
    }

    @Test
    public void returnErrorIfLowerCaseColour() {
        mastermind.setSelectedColours(true);
        try{
            game.setUsersGuess(Arrays.asList("Green", "purple", "Purple", "Yellow"));
        } catch (Error e) {
            Assert.assertEquals("Error: you have given an invalid colour!", e.getMessage());
        }
    }


}
