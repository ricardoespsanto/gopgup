package net.ddns.dustriel.interfaces.console;

/**
 * Main, executable, entry point to start our gop gup system as a console application
 */
public class Main {

    private Main() {
        // Hiding the private constructor
    }

    public static void main(String ... arguments) {

        System.out.println("Using " + arguments[0] + " as arguments");
    }

}
