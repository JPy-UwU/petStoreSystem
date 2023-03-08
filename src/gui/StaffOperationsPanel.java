/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import containers.StaffMapAccess;
import entities.StaffMember;

public class StaffOperationsPanel extends JPanel {
    public StaffOperationsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JButton addButton = new JButton("Add Staff");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffAddFrame frame = new StaffAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        StaffAccessPanel accessPanel = new StaffAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());

        JButton listAllButton = new JButton("List all staff members");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Collection<StaffMember> allStaff = StaffMapAccess.getInstance().values();
                String staffToShow = "";

                for (StaffMember stf: allStaff) {
                    staffToShow = staffToShow + stf + "\n";
                }

                if (staffToShow.equals("")) {
                    staffToShow = "None";
                }
                JOptionPane.showMessageDialog(null, staffToShow);
            }
        });
        add(Box.createVerticalGlue());

        final JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }

    public static final long serialVersionUID = 1;
}
