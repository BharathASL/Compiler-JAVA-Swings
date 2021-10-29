package compiler.core.program;

public enum OperatorConstant {
    EQUAL('='), ADD('+'), SUM('+'), MUL('*'), DIV('/');
    private final char operator;

    OperatorConstant(char operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return Character.toString(operator);
    }
}