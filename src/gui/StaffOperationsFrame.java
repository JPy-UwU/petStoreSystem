/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import javax.swing.JFrame;

/**
 * The frame for the window to display the operations that involve staff members.
 */
public class StaffOperationsFrame extends JFrame {
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 400;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve staff members.
     */
    public StaffOperationsFrame() {
        setTitle("Staff Operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StaffOperationsPanel panel = new StaffOperationsPanel();
        add(panel);
    }

    public static void main(String[] args) {
        StaffOperationsFrame frame = new StaffOperationsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static final long serialVersionUID = 1;
}
