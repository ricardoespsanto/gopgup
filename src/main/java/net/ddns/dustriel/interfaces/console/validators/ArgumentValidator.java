package net.ddns.dustriel.interfaces.console.validators;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import net.ddns.dustriel.interfaces.console.InvalidArgumentsException;

/**
 * Validates arguments given to the start of the system
 */
public class ArgumentValidator {

    private static final Set<String> VALID_MOVIES_APIS = new HashSet<>(1);

    private static final Set<String> VALID_MUSIC_APIS = new HashSet<>(1);

    private static final Predicate<String> API_PREDICATE = argument -> argument.toUpperCase().startsWith("API");

    static {
        VALID_MOVIES_APIS.add("themoviedb");
        VALID_MUSIC_APIS.add("");
    }

    private ArgumentValidator() {
        // Hiding the private constructor
    }

    public static void assertArgumentsAreValid(String[] arguments) {
        try (Stream<String> argumentsStream = Arrays.stream(arguments)) {

            validateAPIIsSpecified(argumentsStream);

            validateKnownAPIs(argumentsStream);

            validateMatchineAPITypeAndSpecificParameter(argumentsStream);
        }
    }

    private static void validateMatchineAPITypeAndSpecificParameter(Stream<String> argumentsStream) {
        if (argumentsStream.filter(VALID_MUSIC_APIS::contains && argument -> argument.toUpperCase().contains("album")).count() != 1) {
            throw new InvalidArgumentsException("");
        }
    }

    private static void validateAPIIsSpecified(Stream<String> argumentsStream) {
        if (argumentsStream.filter(API_PREDICATE).count() != 1) {
            throw new InvalidArgumentsException(
                    "'API' is a required argument. Please specify the API to be used when running your query");
        }
    }

    private static void validateKnownAPIs(Stream<String> argumentsStream) {
        if (argumentsStream.filter(VALID_MOVIES_APIS::contains).count() != 1
                || argumentsStream.filter(VALID_MUSIC_APIS::contains).count() != 1) {
            throw new InvalidArgumentsException(
                    "A known music or movie API is required. Please specify one of " + VALID_MUSIC_APIS + " or "
                            + VALID_MOVIES_APIS);
        }
    }
}
