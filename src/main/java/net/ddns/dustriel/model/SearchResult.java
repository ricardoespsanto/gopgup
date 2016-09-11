package net.ddns.dustriel.model;

/**
 * An abstract base class for all search results
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SearchResult {

}
