package us.bojie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bjiang on 8/16/16.
 */
public class AlphaNumericChooserTest {
    private AlphaNumericChooser chooser;

    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location location = chooser.locationFromInput("B4");

        assertEquals("proper row", 1, location.getRow());
        assertEquals("proper column", 3, location.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception {
        chooser.locationFromInput("WRONG");

    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargerThanMaxIsAllowed() throws Exception {
        chooser.locationFromInput("B52");

    }
}