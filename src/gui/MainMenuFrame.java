/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import javax.swing.JFrame;

/**
 * The frame that includes main menu for the pet store, which contains different navigation options
 */
public class MainMenuFrame extends JFrame {
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 300;

    /**
     * Creates the frame for the main menu for the store
     */
    public MainMenuFrame () {
        setTitle("Main Menu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        MainMenuPanel panel = new MainMenuPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
