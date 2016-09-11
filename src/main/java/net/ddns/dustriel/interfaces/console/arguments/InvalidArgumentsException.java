package net.ddns.dustriel.interfaces.console.arguments;

/**
 * A runtime exception to be thrown when the required arguments are not given
 */
class InvalidArgumentsException extends RuntimeException {

    InvalidArgumentsException(String reasonForException) {
        super(reasonForException);
    }

    InvalidArgumentsException(String reasonForException, Exception exception) {
        super(reasonForException, exception);
    }
}
