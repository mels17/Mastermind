package main;

import java.util.List;

public class UserInputValidation {

    private List<String> userInput;

    private Constants constants;

    public UserInputValidation(List<String> userInput, Constants constants) {
        this.constants = constants;
        this.userInput = userInput;
    }

    public boolean validColours() {
        for (String colour: userInput) {
            if(!constants.getAllPossibleColours().contains(userInput)) {
                System.out.print(constants.getMessages().getInvalidColourErrorMessage());
                return false;
            }
        }
        return true;
    }

    public boolean validArrayLength() {

        if (userInput.size() != constants.getMAX_LIST_SIZE()) {
            System.out.print(this.constants.getMessages().getInvalidArrayLengthErrorMessage());
            return false;
        }
        return true;
    }

    public boolean triesLeft(int noOfTries) {
        if (noOfTries > constants.getMAX_MOVES()) {
            System.out.print(this.constants.getMessages().triesExceededErrorMessage());
            return false;
        }
        return true;
    }

    public boolean isNotNull() {
        if (this.userInput != null) {
            System.out.print(this.constants.getMessages().userInputNotSetMessage());
            return false;
        }
        return true;
    }
}
