package main;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String WON_MESSAGE = "Won";
    private final String WRONG_ANSWER_STRING = "White";
    private final String RIGHT_ANSWER_STRING = "Black";

    public List<String> check(List<String> mastermindList, List<String> userInput) {
        List<String> result = new ArrayList<String>();

        if (mastermindList.equals(userInput)) {
            result.add(WON_MESSAGE);

        } else {
            for (int i = 0; i < 4; i++) {
                if( userInput.get(i) == mastermindList.get(i)) {
                    result.add(RIGHT_ANSWER_STRING);
                } else {
                    result.add(WRONG_ANSWER_STRING);
                }
            }
        }
        return result;
    }
}
