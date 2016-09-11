package net.ddns.dustriel.interfaces.console;

import java.util.Collection;

import net.ddns.dustriel.model.SearchResult;

/**
 * Processes @{@link net.ddns.dustriel.model.SearchResult} into output through the System console
 */
abstract class OutputProcessor {

    private static final long MAX_NUMBER_OF_RESULTS = 4;

    private OutputProcessor() {
        // Hiding the default constructor
    }

    static void displayResults(Collection<? extends SearchResult> searchResults) {
        searchResults.stream().limit(MAX_NUMBER_OF_RESULTS).forEach(System.out::println);
    }
}
