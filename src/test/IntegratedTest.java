package test;

import main.Mastermind;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IntegratedTest {

    @Test
    public void selectFourDifferentRandomColoursFromTheGivenSixColours() {
        List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

        Mastermind game = new Mastermind(true);

        List<String> selectedColours = game.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(0)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(1)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(2)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(3)));
    }

    @Test
    public void selectFourRandomColoursThatMaybeDuplicatesFromTheGivenSixColours() {
        List<String> allPossibleColours = Arrays.asList("Red", "Blue", "Green", "Orange", "Purple", "Yellow");

        Mastermind game = new Mastermind(false);

        List<String> selectedColours = game.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(0)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(1)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(2)));
        Assert.assertTrue(allPossibleColours.contains(selectedColours.get(3)));
    }

}
