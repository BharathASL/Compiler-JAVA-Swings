package compiler.core.program;

public class VarKeyword extends Token {
    public VarKeyword(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    @Override
    public String toString() {
        return "var"
//                + lineNumber + "," + characterAt
                ;
    }
}
