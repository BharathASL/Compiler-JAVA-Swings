package compiler.ui;

import compiler.core.Compiler;
import compiler.core.LexicalAnalyser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    private JTextArea inputCode;
    private JButton lexicalAnalyze;
    private JTextArea outputWindow;
    private JPanel mainPanel;
    private JButton close;
//    private JFrame parentFrame;

    public MainUI(JFrame parentFrame) {
//        this.parentFrame = parentFrame;
        lexicalAnalyze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LexicalAnalyser lexicalAnalyser = Compiler.lexicalAnalyze(inputCode.getText());
                System.out.println(lexicalAnalyser);
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parentFrame.dispose();
            }
        });
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
