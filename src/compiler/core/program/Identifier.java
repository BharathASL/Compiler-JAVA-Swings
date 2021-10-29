package compiler.core.program;

public class Identifier extends Token {
    private final String name;

    public Identifier(int lineNumber, int characterAt, String name) {
        super(lineNumber, characterAt);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name
//                + lineNumber + "," + characterAt
                ;
    }
}
