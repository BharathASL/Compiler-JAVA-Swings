package compiler.core.program;

/**
 * A token class for Identifier
 */
public class Identifier extends Token {
    private final String name;

    /**
     * @param lineNumber Token line number
     * @param characterAt Token character at the location
     * @param name Identifier token
     */
    public Identifier(int lineNumber, int characterAt, String name) {
        super(lineNumber, characterAt);
        this.name = name;
    }

    /**
     * Gets Identifier token
     * @return token string
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return token string
     */
    @Override
    public String toString() {
        return name
//                + lineNumber + "," + characterAt
                ;
    }
}
