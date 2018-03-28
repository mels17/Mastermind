package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private List<String> userInput;

    private int noOfMoves;

    private Constants constants;

    public Game(Constants constants) {
        this.noOfMoves = 0;
        this.constants = constants;
    }

    public void setUsersGuess(List<String> userInput) {
        this.userInput = userInput;
    }

    public List<String> check(List<String> mastermindList) {
        noOfMoves++;
        List<String> result = new ArrayList<String>();

        if (mastermindList.equals(userInput)) {
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
        return result;
    }


}
