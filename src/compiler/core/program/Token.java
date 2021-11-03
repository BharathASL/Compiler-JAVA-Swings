package compiler.core.program;

/**
 * Parent class for all the tokens
 */
public class Token {
    final int lineNumber, characterAt;

    /**
     *
     * @param lineNumber line number
     * @param characterAt token location
     */
    protected Token(int lineNumber, int characterAt) {
        this.lineNumber = lineNumber;
        this.characterAt = characterAt;
    }
}
