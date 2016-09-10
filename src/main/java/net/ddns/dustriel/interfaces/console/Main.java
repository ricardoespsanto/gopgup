package net.ddns.dustriel.interfaces.console;

import net.ddns.dustriel.interfaces.console.validators.ArgumentValidator;

/**
 * Main, executable, entry point to start our gop gup system as a console application
 */
public class Main {

    private Main() {
        // Hiding the private constructor
    }

    public static void main(String... arguments) {
        ArgumentValidator.assertArgumentsAreValid(arguments);
    }
}
