package test;

import main.Constants;
import main.Mastermind;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MastermindClassTest {

    Constants constants = new Constants();
    Mastermind mastermind = new Mastermind(constants);

    @Test
    public void selectFourDifferentRandomColoursFromTheGivenSixColours() {

        mastermind.setSelectedColours(true);

        List<String> selectedColours = mastermind.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(0)));
        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(1)));
        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(2)));
        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(3)));
    }

    @Test
    public void selectFourRandomColoursThatMaybBeDuplicatesFromTheGivenSixColours() {

        mastermind.setSelectedColours(false);
        List<String> selectedColours = mastermind.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(0)));
        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(1)));
        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(2)));
        Assert.assertTrue(constants.getAllPossibleColours().contains(selectedColours.get(3)));
    }
}
