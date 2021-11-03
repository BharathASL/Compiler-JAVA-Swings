package compiler.core;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.HeaderTokenizer;
import compiler.common.Tools;
import compiler.core.program.*;

import java.util.ArrayList;
import java.util.List;

/**
 * First step of compiler
 */
public class LexicalAnalyser {
    private Compiler compiler;
    private final String program;
    //    private LexicalAnalysisState state;
    private List<Token> tokens;
    private LexicalAnalysisReport report;

    /**
     * Object creation restricted for Other classes
     *
     * @param program  program as String
     * @param compiler compiler object for reference
     */
    private LexicalAnalyser(String program, Compiler compiler) {
        this.program = program;
        this.compiler = compiler;
//        this.state = LexicalAnalysisState.OBJECT_CREATION;
        this.tokens = null;
        this.report = null;
    }

    /**
     * Only accessible for sibling classes to restrict the function call
     *
     * @param program  program as String
     * @param compiler compiler object for reference
     * @return LexicalAnalyser itself which is first step of compiler
     */
    protected static LexicalAnalyser newInstance(String program, Compiler compiler) {
        return new LexicalAnalyser(program, compiler);//Created a new Object and sends to its caller
    }

    /**
     * Only accessible for sibling classes to restrict the function call
     *
     * @return After processing the LexicalAnalyser
     * returns the same object with some updated information like report, information for next step
     */
    protected LexicalAnalyser compile() {
        tokens = new ArrayList<>();//Initialize new token list
        try {
            String[] programLines = this.program.split("\n");//Splits all the lines to Array i.e. every line as single element
            for (int i = 0; i < programLines.length; i++) {//Loops each line
                String eachLine = programLines[i];//Each line as element
                String[] initialTokens = eachLine.split(" ");//Splits the line to words as Array
                int charactersRead = 0;//Variable for characters read indicator
                final int lineNumber = i + 1;//Current line number
                for (int j = 0; j < initialTokens.length; j++) {//Words iterator
                    final String eachInitialToken = initialTokens[j];//Word as element
                    String token = eachInitialToken.trim();//Trims the additional string before and after the token
                    final int characterAt = charactersRead + 1;//Current character location
                    switch (token) {//Token identification
                        case "Program:"://Start of the program
                            tokens.add(new ProgramStart(lineNumber, characterAt));//Adds token as program start
                            break;
                        case "var":
                            tokens.add(new VarKeyword(lineNumber, characterAt));//Adds token as var keyword
                            break;
                        case "End":
                            tokens.add(new ProgramEnd(lineNumber, characterAt));//Adds token as program end
                            break;
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                        case "=":
                            tokens.add(new Operator(lineNumber, characterAt, token.charAt(0)));//Adds token as operator
                            break;
                        default:
                            if (token.isEmpty()) {//Skips extra line
                                break;
                            }
                            if (Tools.isStringOnlyAlphabet(token)) {//Checks the token is Identifier or not
                                tokens.add(new Identifier(lineNumber, characterAt, token));//Add token as Identifier
                                break;
                            }
                            throw new LexicalAnalysisException("Invalid token ->" + token + " at (" + lineNumber + "," + characterAt + ")");
                    }
                    charactersRead += eachInitialToken.length();//Updating characters read
                    if (initialTokens.length - 1 != j) {//Not applicable for last token
                        charactersRead++;//Incrementing 1 as character read which is space between the tokens
                    }
                }
                if (programLines.length - 1 != i) {//Not applicable for last line
                    tokens.add(new LineBreak(lineNumber, charactersRead + 1));//Adding token as Line Break
                }
            }
            this.report = new LexicalAnalysisReport(LexicalAnalysisState.COMPILATION_SUCCESS, tokens, null);//Updating the success Lexical Analysis report
//            state = LexicalAnalysisState.COMPILATION_SUCCESS;
        } catch (Exception e) {
            this.report = new LexicalAnalysisReport(LexicalAnalysisState.COMPILATION_FAILED, tokens, e.getMessage());//Updating the error Lexical Analysis report
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

    /**
     *
     * @return gets lexical analysis report
     */
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
