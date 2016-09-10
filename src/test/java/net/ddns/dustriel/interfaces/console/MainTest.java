package net.ddns.dustriel.interfaces.console;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.either;

/**
 * Tests for runtime sanity and other non functional aspects of the system
 */
public class MainTest {

    @Rule
    public ExpectedException noAPIParameterException = ExpectedException.none();

    @Test
    public void appNeedsAParameterSpecifyingTheAPIToQuery() {
        noAPIParameterException.expect(InvalidArgumentsException.class);
        noAPIParameterException.expectMessage("API");
        noAPIParameterException.expectMessage("required");
        Main.main();
    }

    @Test
    public void appNeedsAParameterSpecifyingMovieOrAlbum() {
        noAPIParameterException.expect(InvalidArgumentsException.class);
        noAPIParameterException.expectMessage(either(containsString("movie")).or(containsString("album")));
        Main.main("API=themoviedb");
    }

}
