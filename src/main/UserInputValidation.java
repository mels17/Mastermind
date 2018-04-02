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

    public boolean validColours(List<String> userInput) {
        for (String colour: userInput) {
            if(!constants.getAllPossibleColours().contains(userInput)) {
                errorMessage = constants.getMessages().getInvalidColourErrorMessage();
                return false;
            }
        }
        return true;
    }

    public boolean validArrayLength(List<String> userInput) {

        if (userInput.size() != constants.getMAX_LIST_SIZE()) {
            errorMessage = this.constants.getMessages().getInvalidArrayLengthErrorMessage();
            return false;
        }
        return true;
    }

    public boolean triesLeft(int noOfTries) {
        if (noOfTries > constants.getMAX_MOVES()) {
            errorMessage = this.constants.getMessages().triesExceededErrorMessage();
            return false;
        }
        return true;
    }

    public boolean isNotNull(List<String> userInput) {
        if (userInput == null) {
            errorMessage = this.constants.getMessages().userInputNotSetMessage();
            return false;
        }
        return true;
    }
}
