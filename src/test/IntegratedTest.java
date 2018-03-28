package test;

import main.Constants;
import main.Mastermind;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IntegratedTest {

    @Test
    public void selectFourDifferentRandomColoursFromTheGivenSixColours() {
        List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

        Mastermind mastermind = new Mastermind(new Constants());

        mastermind.setSelectedColours(true);
        List<String> selectedColours = mastermind.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(0)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(1)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(2)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(3)));
    }

    @Test
    public void selectFourRandomColoursThatMaybBeDuplicatesFromTheGivenSixColours() {
        List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

        Mastermind mastermind = new Mastermind(new Constants());

        mastermind.setSelectedColours(false);
        List<String> selectedColours = mastermind.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(0)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(1)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(2)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(3)));
    }

}
