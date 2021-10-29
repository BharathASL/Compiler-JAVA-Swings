package compiler.core.program;

public class ProgramEnd extends Token {
    public ProgramEnd(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    @Override
    public String toString() {
        return "[PROGRAM_END]"
//                + lineNumber + "," + characterAt
                ;
    }
}
