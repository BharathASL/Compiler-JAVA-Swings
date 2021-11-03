package compiler.ui;

import compiler.core.Compiler;
import compiler.core.LexicalAnalyser;
import compiler.core.LexicalAnalysisReport;
import compiler.core.program.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

/**
 * Swing UI class for main frame
 */
public class MainUI {
    private JTextArea inputCode;
    private JButton lexicalAnalyze;
    private JTextArea outputWindow;
    private JPanel mainPanel;
    private JButton close;
//    private JFrame parentFrame;

    public MainUI(JFrame parentFrame) {
//        this.parentFrame = parentFrame;
        //click event for lexical analyze button
        lexicalAnalyze.addActionListener(actionEvent -> {
            LexicalAnalyser lexicalAnalyser = Compiler.lexicalAnalyze(inputCode.getText());//Creates a compiler object and compiler the program for first step
            LexicalAnalysisReport report = lexicalAnalyser.getReport();//Gets report of lexical analysis
            outputWindow.setText(report.getState().toString() + "\nTokens\t:\t" + report.getTokens().stream().map(Token::toString).collect(Collectors.joining(", ")) + "\n" + (report.getLexicalError() == null ? "" : "Errors\t:\t" + report.getLexicalError()));//Updating the console box
            System.out.println(lexicalAnalyser);//Optional print in native console
        });
        close.addActionListener(actionEvent -> parentFrame.dispose());//Close button click event which closes the swing UI application and program
    }

    /**
     *
     * @return main panel object
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
