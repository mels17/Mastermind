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
        if (this.userInputValidation.triesLeft(noOfMoves) &&
                this.userInputValidation.validArrayLength(userInput) && this.userInputValidation.validColours(userInput)) {
            this.userInput = userInput;
        } else {
            throw new Error(this.userInputValidation.getErrorMessage());
        }

    }

    public List<String> check(List<String> mastermindList) {
        noOfMoves++;
        List<String> result = new ArrayList<String>();

        if(this.userInputValidation.isNotNull(userInput)) {
            if (mastermindList.equals(userInput)) {
                result.add(constants.getWON_MESSAGE());
                System.out.print(constants.getWON_MESSAGE());

            } else {
                for (int i = 0; i < 4; i++) {
                    if( userInput.get(i) == mastermindList.get(i)) {
                        result.add(constants.getRIGHT_ANSWER_STRING());
                    } else {
                        result.add(constants.getWRONG_ANSWER_STRING());
                    }
                }
            }
        } else {
            throw new Error(this.userInputValidation.getErrorMessage());
        }
        return result;
    }


}
