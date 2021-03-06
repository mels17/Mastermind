package main;

import java.util.*;

/**
 * This class selects randomly from the list of all possible colours.
 */
public class Mastermind {

    private List<String> selectedColours;

    private Constants constants;

    public Mastermind(Constants constants) {
        this.constants = constants;
        this.selectedColours = new ArrayList<>(constants.MAX_LIST_SIZE);
    }

    public List<String> mastermind (Game game) {
        // Returns an array with Whites and Blacks or Won in it.
        List<String> result = game.check(selectedColours);
        Collections.shuffle(result);
        return result;
    }


    public void setSelectedColours(boolean withoutDuplicateColours) {
        if (withoutDuplicateColours) {
            selectFourDifferentColours(shuffleColours());
        } else {
            selectFourColoursThatCanBeDuplicates();
        }
    }

    public List<String> getSelectedColours() {
        return this.selectedColours;
    }

    private List<String> shuffleColours() {
        List<String> shuffledList = new ArrayList<>(constants.allPossibleColours);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    private void selectFourDifferentColours(List<String> shuffledList) {
        selectedColours = shuffledList.subList(0, constants.MAX_LIST_SIZE);
    }

    private void selectFourColoursThatCanBeDuplicates() {
        Random numberGenerator = new Random();
        int nextRandom;

        for (int i = 0; i < constants.MAX_LIST_SIZE ; i++) {
            nextRandom = numberGenerator.nextInt(constants.allPossibleColours.size() - i);
            selectedColours.add(constants.allPossibleColours.get(nextRandom));
        }
    }
}
