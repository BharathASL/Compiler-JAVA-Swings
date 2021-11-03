package compiler.core.program;

public class VarKeyword extends Token {
    /**
     *
     * @param lineNumber line number
     * @param characterAt token location
     */
    public VarKeyword(int lineNumber, int characterAt) {
        super(lineNumber, characterAt);
    }

    /**
     *
     * @return var keyword as token
     */
    @Override
    public String toString() {
        return "var"
//                + lineNumber + "," + characterAt
                ;
    }
}
