package main;

import java.util.Arrays;
import java.util.List;

/**
 * This class has all the constants used for the mastermind game.
 */
public class Constants {
    private final int MAX_MOVES = 60;
    private final int MAX_LIST_SIZE = 4;

    private final List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

    private final String WON_MESSAGE = "WON";

    private final String WRONG_ANSWER_STRING = "White";
    private final String RIGHT_ANSWER_STRING = "Black";

    private final ErrorMessages messages = new ErrorMessages();

    public int getMAX_MOVES() {
        return MAX_MOVES;
    }

    public int getMAX_LIST_SIZE() {
        return MAX_LIST_SIZE;
    }

    public List<String> getAllPossibleColours() {
        return allPossibleColours;
    }

    public String getWON_MESSAGE() {
        return WON_MESSAGE;
    }

    public String getWRONG_ANSWER_STRING() {
        return WRONG_ANSWER_STRING;
    }

    public String getRIGHT_ANSWER_STRING() {
        return RIGHT_ANSWER_STRING;
    }

    public ErrorMessages getMessages() {
        return messages;
    }
}
