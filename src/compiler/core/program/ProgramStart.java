package compiler.core.program;

public class ProgramStart extends Token {
    public ProgramStart(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    @Override
    public String toString() {
        return "[PROGRAM_START]"
//                + lineNumber + "," + characterAt
                ;
    }
}
