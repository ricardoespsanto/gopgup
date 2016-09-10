package net.ddns.dustriel.interfaces.console;

/**
 * A runtime exception to be thrown when the required arguments are not given
 */
public class InvalidArgumentsException extends RuntimeException {

    public InvalidArgumentsException(String reasonForException) {
        super(reasonForException);
    }
}
