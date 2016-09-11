package net.ddns.dustriel.interfaces.console.arguments;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import com.github.jankroken.commandline.CommandLineParser;
import com.github.jankroken.commandline.OptionStyle;

/**
 */
public abstract class ArgumentsValidator {

    private static final Set<String> KNOWN_MOVIE_APIS = new HashSet<>(1);

    private static final Set<String> KNOWN_MUSIC_APIS = new HashSet<>(1);

    static {
        KNOWN_MOVIE_APIS.add("themoviedb");
        KNOWN_MUSIC_APIS.add("");
    }

    public static Arguments validateArguments(String... arguments) {
        try {
            Arguments parsedArguments = CommandLineParser.parse(Arguments.class, arguments, OptionStyle.SIMPLE);
            if (isAValidMovieArgument(parsedArguments) || isAValidMusicArgument(parsedArguments)) {
                return parsedArguments;
            } else {
                throw new InvalidArgumentsException("If specifying a album API an album also needs to be specified, "
                        + "otherwise please select a movie API and enter a movie title");
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new InvalidArgumentsException("Unable to execute with the given arguments", e);
        }
    }

    private static boolean isAValidMusicArgument(Arguments parsedArguments) {
        final boolean isAMusicAPI =
                KNOWN_MUSIC_APIS.contains(parsedArguments.getApi()) && !parsedArguments.getAlbum().isEmpty();
        if (isAMusicAPI) {
            parsedArguments.setAMusicAPI(true);
        }
        return isAMusicAPI;
    }

    private static boolean isAValidMovieArgument(Arguments parsedArguments) {
        return KNOWN_MOVIE_APIS.contains(parsedArguments.getApi()) && !parsedArguments.getMovie().isEmpty();
    }
}
