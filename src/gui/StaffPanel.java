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

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import commands.AssignStaffToAnimal;
import commands.CommandArguments;
import commands.DropAssociation;
import entities.Manager;
import entities.StaffMember;
import entities.Animal;

public class StaffPanel extends JPanel {
    public StaffPanel(StaffMember staffMember) {
        build(staffMember);
    }

    private void build(StaffMember staffMember) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("First name: " + staffMember.getFirstName()));
        add(new JLabel("Last name: " + staffMember.getLastName()));
        add(new JLabel("Sin: " + staffMember.getSocInsNum()));
        add(new JLabel("Employee ID: " + staffMember.getEmployeeID()));

        if (staffMember instanceof Manager) {
            add(new JLabel("Is Manager: yes"));
        } else {
            add(new JLabel("Is Manager: no"));
        }

        add(new JLabel("    "));
        add(new JLabel("Assigned Animals"));

        for (Animal anim: staffMember.getAssignedAnimals()) {
            JPanel p = listAnimalPanel(staffMember, anim);
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel addAnimalPanel = addAnimalPanel(staffMember);
        add(addAnimalPanel);
        addAnimalPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addAnimalPanel.setMaximumSize(addAnimalPanel.getPreferredSize());

        add(new JLabel("    "));
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    private JPanel listAnimalPanel(final StaffMember stf, final Animal anim) {
        JPanel animalPanel = new JPanel();
        animalPanel.add(new JLabel("    "));
        animalPanel.add(new JLabel(anim.getName()));

        JButton removeButton = new JButton("remove");
        animalPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DropAssociation dropAssoc = new DropAssociation();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sFirstName = stf.getFirstName();
                cmdArguments.sLastName = stf.getLastName();
                cmdArguments.sID = stf.getEmployeeID();
                cmdArguments.aType = anim.getAnimalType();
                cmdArguments.aPetID = anim.getAnimalID();
                cmdArguments.aName = anim.getName();
                dropAssoc.setCommnadArguments(cmdArguments);
                dropAssoc.execute();

                if (dropAssoc.wasSuccessful()) {
                    removeAll();
                    build(stf);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog(StaffPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return animalPanel;
    }

    private JPanel addAnimalPanel(final StaffMember stf) {
        JPanel addAnimalPanel = new JPanel();
        addAnimalPanel.add(new JLabel("Add animal with animal ID"));
        final JTextField textField = new JTextField(10);
        addAnimalPanel.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String aPetID = textField.getText();
                AssignStaffToAnimal addAssoc = new AssignStaffToAnimal();

                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.aPetID = aPetID;
                cmdArguments.sID = stf.getEmployeeID();
                addAssoc.setCommnadArguments(cmdArguments);
                addAssoc.execute();

                if (addAssoc.wasSuccessful()) {
                    removeAll();
                    build(stf);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog(StaffPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addAnimalPanel;
    }

    public static final long serialVersionUID = 1;
}
