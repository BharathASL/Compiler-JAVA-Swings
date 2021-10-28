package compiler.core;

public class Compiler {
    private Compiler() {
    }

    public static LexicalAnalyser lexicalAnalyze(String program) {
        return LexicalAnalyser.newInstance(program, new Compiler());
    }
}
