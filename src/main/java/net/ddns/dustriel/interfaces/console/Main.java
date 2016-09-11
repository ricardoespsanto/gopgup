package net.ddns.dustriel.interfaces.console;

import com.mashape.unirest.http.exceptions.UnirestException;

import net.ddns.dustriel.engines.QueryExecutor;
import net.ddns.dustriel.interfaces.console.arguments.Arguments;
import net.ddns.dustriel.interfaces.console.arguments.ArgumentsValidator;
import net.ddns.dustriel.model.movie.ListOfMovieSearchResults;

/**
 * Main, executable, entry point to start our gop gup system as a console application
 */
public class Main {

    private Main() {
        // Hiding the private constructor
    }

    public static void main(String... arguments) {
        Arguments validatedArguments = ArgumentsValidator.validateArguments(arguments);

        ListOfMovieSearchResults results = null;
        try {
            results = QueryExecutor.execute(validatedArguments);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        OutputProcessor.displayResults(results);
    }
}
