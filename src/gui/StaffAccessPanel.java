/*
 * Name: Jay Patel
 * NSID: neg208
 * Student Number: 11311298
 * CMPT 270-01
 * */

package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StaffAccessPanel extends JPanel {
    JTextField textField;

    public StaffAccessPanel() {
        JLabel promptLabel = new JLabel("Access staff with id");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                String empID = textField.getText();
                StaffFrame frame = null;

                try {
                    frame = new StaffFrame(empID);
                } catch (RuntimeException e) {
                    textField.setText("Invalid id: " + textField.getText());
                    textField.revalidate();
                    return;
                }

                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                textField.setText("");
                textField.revalidate();
            }
        });
    }
    public static final long serialVersionUID = 1;
}
