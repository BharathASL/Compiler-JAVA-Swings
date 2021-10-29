package compiler.core;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.HeaderTokenizer;
import compiler.common.Tools;
import compiler.core.program.*;

import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyser {
    private Compiler compiler;
    private final String program;
    //    private LexicalAnalysisState state;
    private List<Token> tokens;
    private LexicalAnalysisReport report;

    private LexicalAnalyser(String program, Compiler compiler) {
        this.program = program;
        this.compiler = compiler;
//        this.state = LexicalAnalysisState.OBJECT_CREATION;
        this.tokens = null;
        this.report = null;
    }

    protected static LexicalAnalyser newInstance(String program, Compiler compiler) {
        return new LexicalAnalyser(program, compiler);
    }

    protected LexicalAnalyser compile() {
        tokens = new ArrayList<>();
        try {
            String[] programLines = this.program.split("\n");
            for (int i = 0; i < programLines.length; i++) {
                String eachLine = programLines[i];
                String[] initialTokens = eachLine.split(" ");
                int charactersRead = 0;
                final int lineNumber = i + 1;
                for (int j = 0; j < initialTokens.length; j++) {
                    final String eachInitialToken = initialTokens[j];
                    String token = eachInitialToken.trim();
                    final int characterAt = charactersRead + 1;
                    switch (token) {
                        case "Program:":
                            tokens.add(new ProgramStart(lineNumber, characterAt));
                            break;
                        case "var":
                            tokens.add(new VarKeyword(lineNumber, characterAt));
                            break;
                        case "End":
                            tokens.add(new ProgramEnd(lineNumber, characterAt));
                            break;
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                        case "=":
                            tokens.add(new Operator(lineNumber, characterAt, token.charAt(0)));
                            break;
                        default:
                            if (token.isEmpty()) {
                                break;
                            }
                            if (Tools.isStringOnlyAlphabet(token)) {
                                tokens.add(new Identifier(lineNumber, characterAt, token));
                                break;
                            }
                            throw new LexicalAnalysisException("Invalid token ->" + token + " at (" + lineNumber + "," + characterAt + ")");
                    }
                    charactersRead += eachInitialToken.length();
                    if (initialTokens.length - 1 != j) {
                        charactersRead++;
                    }
                }
                if (programLines.length - 1 != i) {
                    tokens.add(new LineBreak(lineNumber, charactersRead + 1));
                }
            }
            this.report = new LexicalAnalysisReport(LexicalAnalysisState.COMPILATION_SUCCESS, tokens, null);
//            state = LexicalAnalysisState.COMPILATION_SUCCESS;
        } catch (Exception e) {
            this.report = new LexicalAnalysisReport(LexicalAnalysisState.COMPILATION_FAILED, tokens, e.getMessage());
//            state = LexicalAnalysisState.COMPILATION_FAILED;
            e.printStackTrace();
        }
        return this;
    }

//    public List<Token> getTokens() {
//        return tokens;
//    }

//    public LexicalAnalysisState getState() {
//        return state;
//    }

    public LexicalAnalysisReport getReport() {
        return report;
    }

    @Override
    public String toString() {
        return "LexicalAnalyser{" +
                "compiler=" + compiler +
                ", program='" + program + '\'' +
                '}';
    }
}
