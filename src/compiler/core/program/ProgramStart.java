package compiler.core.program;

public class ProgramStart extends Token {
    /**
     *
     * @param lineNumber line number
     * @param characterAt token location
     */
    public ProgramStart(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    /**
     *
     * @return dummy token for identification
     */
    @Override
    public String toString() {
        return "Program:"
//                + lineNumber + "," + characterAt
                ;
    }
}
