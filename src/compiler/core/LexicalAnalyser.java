package compiler.core;

public class LexicalAnalyser {
    private Compiler compiler;
    private final String program;

    private LexicalAnalyser(String program, Compiler compiler) {
        this.program = program;
        this.compiler = compiler;
    }

    protected static LexicalAnalyser newInstance(String program, Compiler compiler) {
        return new LexicalAnalyser(program, compiler);
    }

    @Override
    public String toString() {
        return "LexicalAnalyser{" +
                "compiler=" + compiler +
                ", program='" + program + '\'' +
                '}';
    }
}
