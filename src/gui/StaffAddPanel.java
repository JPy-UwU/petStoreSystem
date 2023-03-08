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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.AddStaff;
import commands.CommandArguments;

public class StaffAddPanel extends JPanel {
    JTextArea error = null;
    ValueEntryPanel fNamePanel;
    ValueEntryPanel lNamePanel;
    ValueEntryPanel sinPanel;
    ValueEntryPanel empIDPanel;
    ValueEntryPanel isManagerPanel;

    public StaffAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JLabel prompt = new JLabel("Enter Staff Member Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        fNamePanel = new ValueEntryPanel("First Name");
        fNamePanel.setMaximumSize(fNamePanel.getPreferredSize());
        add(fNamePanel);
        fNamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        lNamePanel = new ValueEntryPanel("Last Name");
        lNamePanel.setMaximumSize(lNamePanel.getPreferredSize());
        add(lNamePanel);
        lNamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        sinPanel = new ValueEntryPanel("SIN");
        sinPanel.setMaximumSize(sinPanel.getPreferredSize());
        add(sinPanel);
        sinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        empIDPanel = new ValueEntryPanel("Employee ID");
        empIDPanel.setMaximumSize(empIDPanel.getPreferredSize());
        add(empIDPanel);
        empIDPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        isManagerPanel = new ValueEntryPanel("Is Manager?");
        isManagerPanel.setMaximumSize(isManagerPanel.getPreferredSize());
        add(isManagerPanel);
        isManagerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new StaffAddPanel.SubmitListener());
        add(Box.createVerticalGlue());
    }

    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                remove(error);
                error = null;
            }

            String fName = fNamePanel.getValueAsString();
            String lName = lNamePanel.getValueAsString();
            String sin = sinPanel.getValueAsString();
            String empID = empIDPanel.getValueAsString();
            String isManager = isManagerPanel.getValueAsString();
            AddStaff addStaff = new AddStaff();

            CommandArguments cmdArguments = new CommandArguments();
            cmdArguments.sFirstName = fName;
            cmdArguments.sLastName = lName;
            cmdArguments.sSIN = sin;
            cmdArguments.sID = empID;
            cmdArguments.response = isManager;
            addStaff.setCommnadArguments(cmdArguments);
            addStaff.execute();

            if (addStaff.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
            } else {
                error = new JTextArea(SplitString.at(addStaff.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the window as it has changed
            }
        }
    }

    public static final long serialVersionUID = 1;
}
