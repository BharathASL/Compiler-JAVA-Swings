package compiler.common;

/**
 * Class which contains static utilities
 */
public class Tools {
    /**
     *
     * @param str input string
     * @return returns if the input String is only contains alphabet
     */
    public static boolean isStringOnlyAlphabet(String str) {
        return (str != null && (!str.isEmpty()) && str.matches("^[a-zA-Z]*$"));
    }
}
