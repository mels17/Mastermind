package test;

import main.Constants;
import main.UserInputValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class UserInputValidationTest {

    Constants constants;
    UserInputValidation userInputValidation;

    @Before
            public void initializeObjects() {
        constants = new Constants();
        userInputValidation = new UserInputValidation(constants);
    }

    @Test
    public void givenInvalidColoursReturnFalse() {
        Assert.assertFalse(userInputValidation.validColours(Arrays.asList("Red", "Blue", "Indigo", "Orange")));
    }

    @Test
    public void givenInvalidColoursInitializesErrorMessage() {
        userInputValidation.validColours(Arrays.asList("Red", "Blue", "Indigo", "Orange"));
        Assert.assertEquals("Error: you have given an invalid colour!", userInputValidation.getErrorMessage());
    }

    @Test
    public void givenLowerCaseColourColoursReturnFalse() {
        Assert.assertFalse(userInputValidation.validColours(Arrays.asList("Red", "Blue", "green", "Orange")));
    }

    @Test
    public void givenAllValidColoursReturnTrue() {
        Assert.assertTrue(userInputValidation.validColours(Arrays.asList("Red", "Purple", "Green", "Yellow")));
    }

    @Test
    public void givenArrayWithInvalidLengthReturnFalse() {
        Assert.assertFalse(userInputValidation.validArrayLength(Arrays.asList("Red")));
    }

    @Test
    public void givenArrayWithInvalidLengthInitializeErrorMessage() {
        userInputValidation.validArrayLength(Arrays.asList("Red", "Green"));
        Assert.assertEquals("Error: you must pass 4 colours!", userInputValidation.getErrorMessage());
    }


    @Test
    public void givenArrayWithCorrectLengthReturnTrue() {
        Assert.assertTrue(userInputValidation.validArrayLength(Arrays.asList("Red", "Green", "Blue", "Purple")));
    }

    @Test
    public void returnsTrueForThe60thTry() {
        Assert.assertTrue(userInputValidation.triesLeft(60));
    }

    @Test
    public void returnsFalseIfMoreThan60Tries() {
        Assert.assertFalse(userInputValidation.triesLeft(65));
    }

    @Test
    public void returnsFalseIfUserInputIsNull() {
        Assert.assertFalse(userInputValidation.isNotNull(null));
    }


    @Test
    public void returnsTrueIfUserInputIsNotNull() {
        Assert.assertTrue(userInputValidation.isNotNull(Arrays.asList("Green", "Red", "Purple", "Orange")));
    }
}
