package compiler.core;

import compiler.core.program.Token;

import java.util.List;

public class LexicalAnalysisReport {
    private final LexicalAnalysisState state;
    private final List<Token> tokens;
    private final String lexicalError;

    public LexicalAnalysisReport(LexicalAnalysisState state, List<Token> tokens, String lexicalError) {
        this.state = state;
        this.tokens = tokens;
        this.lexicalError = lexicalError;
    }

    public LexicalAnalysisState getState() {
        return state;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getLexicalError() {
        return lexicalError;
    }
}
