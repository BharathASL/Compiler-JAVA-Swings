package compiler.common;

public class Tools {
    public static boolean isStringOnlyAlphabet(String str) {
        return (str != null && (!str.isEmpty()) && str.matches("^[a-zA-Z]*$"));
    }
}
