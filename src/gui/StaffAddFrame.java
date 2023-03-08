/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import javax.swing.JFrame;

public class StaffAddFrame extends JFrame {
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 300;

    /**
     * Create the frame to add a new staff
     */
    public StaffAddFrame() {
        setTitle("Staff addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StaffAddPanel panel = new StaffAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
