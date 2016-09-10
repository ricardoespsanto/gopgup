import org.junit.Test;

import net.ddns.dustriel.interfaces.console.InvalidArgumentsException;
import net.ddns.dustriel.interfaces.console.Main;

/**
 * Tests for runtime sanity and other non functional aspects of the system
 */
public class MainTest {

    @Test(expected = InvalidArgumentsException.class)
    public void appNeedsAParameterSpecifyingTheAPIToQuery() {
        Main.main();
    }

}
