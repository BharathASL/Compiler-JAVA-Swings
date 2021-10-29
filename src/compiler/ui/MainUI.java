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

public class MainUI {
    private JTextArea inputCode;
    private JButton lexicalAnalyze;
    private JTextArea outputWindow;
    private JPanel mainPanel;
    private JButton close;
//    private JFrame parentFrame;

    public MainUI(JFrame parentFrame) {
//        this.parentFrame = parentFrame;
        lexicalAnalyze.addActionListener(actionEvent -> {
            LexicalAnalyser lexicalAnalyser = Compiler.lexicalAnalyze(inputCode.getText());
            LexicalAnalysisReport report = lexicalAnalyser.getReport();
            outputWindow.setText(report.getState().toString() + "\nTokens\t:\t" + report.getTokens().stream().map(Token::toString).collect(Collectors.joining(", ")) + "\n" + (report.getLexicalError() == null ? "" : "Errors\t:\t" + report.getLexicalError()));
            System.out.println(lexicalAnalyser);
        });
        close.addActionListener(actionEvent -> parentFrame.dispose());
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
