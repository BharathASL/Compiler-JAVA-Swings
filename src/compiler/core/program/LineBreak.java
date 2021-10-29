package compiler.core.program;

public class LineBreak extends Token {

    public LineBreak(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    @Override
    public String toString() {
        return "[LINE_BREAK]"
//                + lineNumber + "," + characterAt
                ;
    }
}
