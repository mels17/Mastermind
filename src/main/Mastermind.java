package main;

import java.util.*;

public class Mastermind {

    private boolean DUPLICATES_ALLOWED = true;

    private List<String> selectedColours;

    private Constants constants;

    public Mastermind(Constants constants) {
        this.constants = constants;
        this.selectedColours = new ArrayList<>(constants.getMAX_LIST_SIZE());
    }

    public List<String> mastermind (Game game) {
        List<String> result = game.check(selectedColours);
        Collections.shuffle(result);
        return result;
    }


    public void setSelectedColours(boolean withoutDuplicateColours) {
        selectedColours = withoutDuplicateColours ? selectFourDifferentColours(shuffleColours()) : selectFourColoursThatCanBeDuplicates();
    }

    public List<String> getSelectedColours() {
        return selectedColours;
    }

    private List<String> shuffleColours() {
        List<String> shuffledList = new ArrayList<>(constants.getAllPossibleColours());
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    private List<String> selectFourDifferentColours(List<String> shuffledList) {
        selectedColours = shuffledList.subList(0, constants.getMAX_LIST_SIZE());
        return selectedColours;
    }

    private List<String> selectFourColoursThatCanBeDuplicates() {
        Random numberGenerator = new Random();
        int nextRandom;

        for (int i = 0; i < constants.getMAX_LIST_SIZE() ; i++) {
            nextRandom = numberGenerator.nextInt(6 - i);
            selectedColours.add(constants.getAllPossibleColours().get(nextRandom));
        }

        return selectedColours;

    }
}
