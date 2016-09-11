package net.ddns.dustriel.interfaces.console;

import net.ddns.dustriel.model.ListOfSearchResults;

/**
 * Processes @{@link net.ddns.dustriel.model.SearchResult} into output through the System console
 */
abstract class OutputProcessor {

    private OutputProcessor() {
        // Hiding the default constructor
    }

    static void displayResults(ListOfSearchResults searchResults) {
        searchResults.getListOfSearchResults().forEach(System.out::println);
    }
}
