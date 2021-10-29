package compiler.core.program;

import java.util.Arrays;

public class Operator extends Token {

    private final char operator;

    public Operator(int lineNumber, int characterAt, char operator) {
        super(lineNumber, characterAt);
        this.operator = operator;
    }

    public char getOperator() {
        return this.operator;
    }

    @Override
    public String toString() {
        return Character.toString(operator)
//                + lineNumber + "," + characterAt
                ;
    }
}
