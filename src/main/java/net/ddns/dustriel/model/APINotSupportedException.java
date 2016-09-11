package net.ddns.dustriel.model;

/**
 * Thrown when choosing a non supported API
 */
public class APINotSupportedException extends RuntimeException {

    public APINotSupportedException(String s) {
        super(s);
    }
}
