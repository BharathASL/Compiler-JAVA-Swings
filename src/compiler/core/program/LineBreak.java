package compiler.core.program;

public class LineBreak extends Token {
    /**
     * @param lineNumber line number
     * @param characterAt token location
     */
    public LineBreak(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    /**
     *
     * @return Dummy Line break token
     */
    @Override
    public String toString() {
        return "[LINE_BREAK]"
//                + lineNumber + "," + characterAt
                ;
    }
}
