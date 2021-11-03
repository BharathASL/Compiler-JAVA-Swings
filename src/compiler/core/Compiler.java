package compiler.core;

/**
 * Class for accessing the compiler
 */
public class Compiler {
    /**
     * Restricting Object creation
     */
    private Compiler() {
    }

    /**
     * Singleton approach to get compiler object
     * @param program program as String
     * @return return LexicalAnalyser which is first step of compiler
     */
    public static LexicalAnalyser lexicalAnalyze(String program) {
//        return LexicalAnalyser.newInstance(program, new Compiler()).compile();
        return LexicalAnalyser.newInstance(program, null).compile();//Creates LexicalAnalyser
    }
}
