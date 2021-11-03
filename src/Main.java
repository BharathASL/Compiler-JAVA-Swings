import compiler.ui.MainUI;

import javax.swing.*;

/**
 * Main class
 */
public class Main {
    /**
     * Main function
     * @param args command line arguments - no arguments for our application
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();//New JFrame instance for our class
        MainUI ui = new MainUI(frame);//Object creation of swing UI class
        frame.setContentPane(ui.getMainPanel());//Sets JPanel as content frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Closes the application with we click close at top right conner
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);//Full size window
        frame.pack();//Finalize the config and pack the UI
        frame.setVisible(true);//Make the Frame visible to the screen
    }
}
