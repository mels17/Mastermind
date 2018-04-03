package test;

import main.Constants;
import main.Game;
import main.Mastermind;
import main.UserInputValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class MastermindClassTest {

    private class DummyGameClass extends Game {

        public DummyGameClass(Constants constants, UserInputValidation userInputValidation) {
            super(constants, userInputValidation);
        }

        @Override
        public List<String> check(List<String> mastermindColours) {
            return Arrays.asList("White", "Black", "White", "Black");
        }
    }

    Constants constants;
    Mastermind mastermind;

    @Before
    public void initializeObjects() {
        constants = new Constants();
        mastermind = new Mastermind(constants);
    }

    @Test
    public void selectFourDifferentRandomColoursFromTheGivenSixColours() {

        mastermind.setSelectedColours(true);

        List<String> selectedColours = mastermind.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(0)));
        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(1)));
        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(2)));
        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(3)));
    }

    @Test
    public void selectFourRandomColoursThatMaybBeDuplicatesFromTheGivenSixColours() {

        mastermind.setSelectedColours(false);
        List<String> selectedColours = mastermind.getSelectedColours();

        Assert.assertEquals(4, selectedColours.size());

        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(0)));
        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(1)));
        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(2)));
        Assert.assertTrue(constants.allPossibleColours.contains(selectedColours.get(3)));
    }

    @Test
    public void checkIfResultArrayIsShuffled() {
        Constants constants = new Constants();
        DummyGameClass dummy = new DummyGameClass(constants, new UserInputValidation(constants));
        List<String> actualResultArray = mastermind.mastermind(dummy);
        List<String> expectedResultArray = Arrays.asList("White", "Black", "White", "Black");

        Assert.assertNotEquals(expectedResultArray, actualResultArray );
    }
}
