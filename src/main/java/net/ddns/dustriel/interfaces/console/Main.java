package net.ddns.dustriel.interfaces.console;

import java.util.Collection;

import net.ddns.dustriel.engines.QueryExecutor;
import net.ddns.dustriel.model.SearchResult;

/**
 * Main, executable, entry point to start our gop gup system as a console application
 */
public class Main {

    private Main() {
        // Hiding the private constructor
    }

    public static void main(String... arguments) {
        Collection<? extends SearchResult> results = QueryExecutor.execute();
        OutputProcessor.displayResults(results);
    }
}
