package main;

import java.util.*;

public class Mastermind {

    private List<String> selectedColours = new ArrayList<String>(4);
    List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

    public Mastermind(boolean coloursCanHaveDuplicates) {
        setSelectedColours(coloursCanHaveDuplicates);
    }

    private List<String> shuffleColours() {
        List<String> shuffledList = new ArrayList<String>(allPossibleColours);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    private List<String> selectFourDifferentColours(List<String> shuffledList) {
        selectedColours = shuffledList.subList(0, 4);
        return selectedColours;
    }

    public void setSelectedColours(boolean withoutDuplicateColours) {
        selectedColours = withoutDuplicateColours ? selectFourDifferentColours(shuffleColours()) : selectFourColoursThatCanBeDuplicates();
    }

    public List<String> getSelectedColours() {
        return selectedColours;
    }
    private List<String> selectFourColoursThatCanBeDuplicates() {
        Random numberGenerator = new Random();
        int nextRandom;

        for (int i = 0; i < 4 ; i++) {
            nextRandom = numberGenerator.nextInt(6 - i);
            selectedColours.add(allPossibleColours.get(nextRandom));
        }

        return selectedColours;

    }
}
