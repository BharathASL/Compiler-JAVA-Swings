package compiler.core.program;

import java.util.Arrays;

public class Operator extends Token {

    private final char operator;

    /**
     *
     * @param lineNumber line number
     * @param characterAt token location
     * @param operator operator token
     */
    public Operator(int lineNumber, int characterAt, char operator) {
        super(lineNumber, characterAt);
        this.operator = operator;
    }

    /**
     *
     * @return operator token as char
     */
    public char getOperator() {
        return this.operator;
    }

    /**
     *
     * @return Token character as String
     */
    @Override
    public String toString() {
        return Character.toString(operator)
//                + lineNumber + "," + characterAt
                ;
    }
}
