package compiler.core;

public class Compiler {
    private Compiler() {
    }

    public static LexicalAnalyser lexicalAnalyze(String program) {
//        return LexicalAnalyser.newInstance(program, new Compiler()).compile();
        return LexicalAnalyser.newInstance(program, null).compile();
    }
}
