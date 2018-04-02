package main;

/**
 * This class has all the string error messages required for the mastermind class.
 */
public class ErrorMessages {
    public String getInvalidColourErrorMessage() {
        return "Error: you have given an invalid colour!";
    }

    public String getInvalidArrayLengthErrorMessage() {
        return "Error: you must pass 4 colours!";
    }

    public String triesExceededErrorMessage() {
        return "Error: you have had more than 60 tries!";
    }

    public String userInputNotSetMessage() {
        return "Error: you have not entered any colours!";
    }
}
