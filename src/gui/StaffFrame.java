/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import javax.swing.JFrame;
import containers.StaffMapAccess;
import entities.StaffMember;

public class StaffFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 350;
    public static final int DEFAULT_HEIGHT = 400;

    public StaffFrame(String empID) {
        StaffMember staffMember = StaffMapAccess.getInstance().get(empID);
        if (staffMember != null) {
            setTitle(staffMember.getFirstName() + " " + staffMember.getLastName() + " (" + empID + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            StaffPanel panel = new StaffPanel(staffMember);
            add(panel);
        } else {
            throw new RuntimeException("Invalid ID " + empID);
        }
    }
    public static final long serialVersionUID = 1;
}
