package net.ddns.dustriel.engines;

import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import net.ddns.dustriel.model.InvalidMappingException;
import net.ddns.dustriel.model.SearchResult;
import net.ddns.dustriel.engines.implementations.movie.omdb.model.ListOfMovieSearchResults;

/**
 * An interface to ensure that our finder classes do not have to set up the jackson object mapper each time
 */
public interface Finder {

    /**
     * Given any search string, it will look for movies and return a set of useful information regarding the results.
     *
     * @param movieSearch a simple string to use when searching for the movies
     * @return A @{@link ListOfMovieSearchResults} with details of the findings filled in
     */
    Collection<? extends SearchResult> listAllMatchesWithShortDetails(String movieSearch);

    /*
     * Unirest maintains this state so we only need to run this once
     */
    default void setUpTheMapperToOurResponseType() {
        Unirest.setObjectMapper(new ObjectMapper() {

            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new InvalidMappingException(e);
                }
            }

            @Override
            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new InvalidMappingException(e);
                }
            }
        });
    }

}
