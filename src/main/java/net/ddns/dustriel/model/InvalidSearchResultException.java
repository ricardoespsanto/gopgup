package net.ddns.dustriel.model;

/**
 * Exception thrown when something goes wrong with a search
 */
public class InvalidSearchResultException extends RuntimeException {

    public InvalidSearchResultException(String message) {
        super(message);
    }

}
