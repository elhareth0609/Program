import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsPanel extends JPanel {

    public ControlsPanel() {
        setLayout(new FlowLayout());

        // Create control buttons
        JButton colorButton = new JButton("Color");
        JButton fontSizeButton = new JButton("Font Size");
        JButton idButton = new JButton("ID");
        JButton marginButton = new JButton("Margin");
        JButton paddingButton = new JButton("Padding");

        // Add action listeners to the buttons
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle color button action
                JOptionPane.showMessageDialog(null, "Set Color");
            }
        });

        fontSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle font size button action
                JOptionPane.showMessageDialog(null, "Set Font Size");
            }
        });

        idButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle ID button action
                JOptionPane.showMessageDialog(null, "Set ID");
            }
        });

        marginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle margin button action
                JOptionPane.showMessageDialog(null, "Set Margin");
            }
        });

        paddingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle padding button action
                JOptionPane.showMessageDialog(null, "Set Padding");
            }
        });

        // Add buttons to the controls panel
        add(colorButton);
        add(fontSizeButton);
        add(idButton);
        add(marginButton);
        add(paddingButton);
    }
}
