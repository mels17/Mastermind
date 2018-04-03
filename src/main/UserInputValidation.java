package main;

import java.util.List;

/**
 * Validate user input - the colours passed.
 */
public class UserInputValidation {
    private Constants constants;

    private String errorMessage;

    public UserInputValidation(Constants constants) {
        this.constants = constants;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean userGuessIsValid(List<String> userGuess) {
        return validArrayLength(userGuess) && validColours(userGuess) && isNotNull(userGuess);
    }

    public boolean validColours(List<String> userInput) {
        for (String colour: userInput) {
            if(!constants.allPossibleColours.contains(colour)) {
                errorMessage = constants.messages.getInvalidColourErrorMessage();
                return false;
            }
        }
        return true;
    }

    public boolean validArrayLength(List<String> userInput) {

        if (userInput.size() != constants.MAX_LIST_SIZE) {
            errorMessage = this.constants.messages.getInvalidArrayLengthErrorMessage();
            return false;
        }
        return true;
    }

    public boolean triesLeft(int noOfTries) {
        if (noOfTries > constants.MAX_MOVES) {
            errorMessage = this.constants.messages.triesExceededErrorMessage();
            return false;
        }
        return true;
    }

    public boolean isNotNull(List<String> userInput) {
        if (userInput == null) {
            errorMessage = this.constants.messages.userInputNotSetMessage();
            return false;
        }
        return true;
    }
}
