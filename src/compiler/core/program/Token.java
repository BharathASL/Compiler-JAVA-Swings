package compiler.core.program;

public class Token {
    final int lineNumber, characterAt;

    protected Token(int lineNumber, int characterAt) {
        this.lineNumber = lineNumber;
        this.characterAt = characterAt;
    }
}
