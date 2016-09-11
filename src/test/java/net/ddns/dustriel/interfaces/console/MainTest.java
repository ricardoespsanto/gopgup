package net.ddns.dustriel.interfaces.console;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ddns.dustriel.model.APINotSupportedException;

/**
 * Tests for runtime sanity and other non functional aspects of the system
 */
public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void searchingForMoviesProducesTheNumberOfRecordsLimitedByOutputProcessor() {
        System.setProperty("api", "omdb");
        System.setProperty("movie", "Indiana Jones");
        Main.main();

        // Ensure that this number matches the result limiter @OutputProcessor.MAX_NUMBER_OF_RESULTS
        Assert.assertEquals(4, outContent.toString().split(System.lineSeparator()).length);
        Assert.assertNotNull(errContent.toString());
    }

    @Test
    public void notSpecifyingAMovieWillResultInError() {
        System.setProperty("api", "omdb");
        Main.main();
        Assert.assertNotNull(errContent.toString());
    }

    @Test(expected = APINotSupportedException.class)
    public void specifyingAnInvalidAPIWillThrowAnException() {
        System.setProperty("api", "imdb");
        Main.main();
    }

    @Test
    public void searchingForAlbumsProducesTheNumberOfRecordsLimitedByOutputProcessor() {
        System.setProperty("api", "spotify");
        System.setProperty("album", "Smells like teen spirit");
        Main.main();

        // Ensure that this number matches the result limiter @OutputProcessor.MAX_NUMBER_OF_RESULTS
        Assert.assertEquals(4, outContent.toString().split(System.lineSeparator()).length);
        Assert.assertNotNull(errContent.toString());
    }

}
