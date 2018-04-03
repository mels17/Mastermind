package main;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<String> userInput;

    private int noOfMoves;

    private Constants constants;
    private UserInputValidation userInputValidation;

    public Game(Constants constants, UserInputValidation userInputValidation) {
        this.noOfMoves = 0;
        this.constants = constants;
        this.userInputValidation = userInputValidation;
    }

    public void setUsersGuess(List<String> userInput) {
        if (this.userInputValidation.triesLeft(noOfMoves) && this.userInputValidation.userGuessIsValid(userInput)) {
            this.userInput = userInput;
        } else {
            throw new Error(this.userInputValidation.getErrorMessage());
        }

    }

    public List<String> check(List<String> mastermindList) {
        List<String> result = new ArrayList<String>();
        if(userInput == null || userInput.isEmpty()) {
            throw new Error("Error: User guess not initialized.");
        } else {
            noOfMoves++;
            if (mastermindList.equals(userInput)) {
                result.add(constants.WON_MESSAGE);
                System.out.print(constants.WON_MESSAGE);
            } else {
                result = getResult(mastermindList);
            }
        }
        return result;
    }

    private List<String> getResult(List<String> mastermindList) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < constants.MAX_LIST_SIZE; i++) {
            if( userInput.get(i).equals(mastermindList.get(i))) {
                result.add(constants.RIGHT_ANSWER_STRING);
            } else {
                result.add(constants.WRONG_ANSWER_STRING);
            }
        }
        return result;
    }


}
