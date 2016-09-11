package net.ddns.dustriel.model;

/**
 * An abstract base class for all search results
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A marker class to match search results to a type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SearchResult {

}
