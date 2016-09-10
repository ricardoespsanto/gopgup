package net.ddns.dustriel.interfaces.console;

import java.util.Arrays;

/**
 * Main, executable, entry point to start our gop gup system as a console application
 */
public class Main {

    private Main() {
        // Hiding the private constructor
    }

    public static void main(String... arguments) {

        assertArgumentsAreValid(arguments);
        System.out.println("Using " + arguments[0] + " as arguments");
    }

    private static void assertArgumentsAreValid(String[] arguments) {
        if (Arrays.stream(arguments).filter(argument -> argument.equalsIgnoreCase("API")).count() != 1) {
            throw new InvalidArgumentsException(
                    "'API' is a required argument. Please specify the API to be used when running your query");
        }
    }

}
