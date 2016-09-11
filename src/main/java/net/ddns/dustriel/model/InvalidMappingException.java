package net.ddns.dustriel.model;

import java.io.IOException;

/**
 * Thrown when a mapping cannot be performed by our object mapper
 */
public class InvalidMappingException extends RuntimeException {

    public InvalidMappingException(IOException e) {
        super(e);
    }

}
