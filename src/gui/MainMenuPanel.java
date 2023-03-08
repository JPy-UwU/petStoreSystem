/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The panel that includes main menu for the pet store, which contains different navigation options
 */
public class MainMenuPanel extends JPanel {
    public MainMenuPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        JButton animalOperations = new JButton("Animal Operations");
        animalOperations.setMaximumSize(animalOperations.getPreferredSize());
        add(animalOperations);
        animalOperations.setAlignmentX(Component.CENTER_ALIGNMENT);
        animalOperations.addActionListener(new animalOperationListener());
        add(Box.createVerticalGlue());

        JButton staffOperations = new JButton("Staff Member Operations");
        staffOperations.setMaximumSize(staffOperations.getPreferredSize());
        add(staffOperations);
        staffOperations.setAlignmentX(Component.CENTER_ALIGNMENT);
        staffOperations.addActionListener(new staffOperationListener());
        add(Box.createVerticalGlue());

        JButton kennelsPenal = new JButton("Kennels");
        kennelsPenal.setMaximumSize(kennelsPenal.getPreferredSize());
        add(kennelsPenal);
        kennelsPenal.setAlignmentX(Component.CENTER_ALIGNMENT);
        kennelsPenal.addActionListener(new KennelsPanelListener());
        add(Box.createVerticalGlue());


        JButton exitButton = new JButton("Exit");
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

    private class animalOperationListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            getTopLevelAncestor().setVisible(false);
            getTopLevelAncestor().setVisible(false);
            AnimalOperationsFrame frame = new AnimalOperationsFrame();
            frame.setLocation(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    private class staffOperationListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            getTopLevelAncestor().setVisible(false);
            getTopLevelAncestor().setVisible(false);
            StaffOperationsFrame frame = new StaffOperationsFrame();
            frame.setLocation(300,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    private class KennelsPanelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            getTopLevelAncestor().setVisible(false);
            getTopLevelAncestor().setVisible(false);
            JFrame frame = new JFrame();
            frame.setSize(300, 300);
            frame.setLocation(300,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            KennelsPanel panel = new KennelsPanel();
            frame.add(panel);
            panel.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.setMaximumSize(panel.getPreferredSize());
        }
    }

    public static final long serialVersionUID = 1;
}
