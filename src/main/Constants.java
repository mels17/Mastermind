package main;

import java.util.Arrays;
import java.util.List;

/**
 * This class has all the constants used for the mastermind game.
 */
public class Constants {
    public final int MAX_MOVES = 60;
    public final int MAX_LIST_SIZE = 4;

    public final List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

    public final String WON_MESSAGE = "WON";

    public final String WRONG_ANSWER_STRING = "White";
    public final String RIGHT_ANSWER_STRING = "Black";

    public final ErrorMessages messages = new ErrorMessages();
}
