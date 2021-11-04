package compiler.core.program;

public class ProgramEnd extends Token {
    /**
     *
     * @param lineNumber line number
     * @param characterAt token location
     */
    public ProgramEnd(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    /**
     *
     * @return dummy token for identification
     */
    @Override
    public String toString() {
        return "End"
//                + lineNumber + "," + characterAt
                ;
    }
}
