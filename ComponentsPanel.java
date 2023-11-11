import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComponentsPanel extends JPanel {

    private JPanel phoneInterface;
    private int offsetX, offsetY; // Declare offsetX and offsetY at a higher scope

    public ComponentsPanel(JPanel phoneInterface) {
        this.phoneInterface = phoneInterface;
        setLayout(new GridLayout(5, 1));
        setPreferredSize(new Dimension(200, 0));

        addButton("Button");
        addTextField("TextField");
        addTextView("Label");

        JButton controllerButton = new JButton("Controller");
        controllerButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Controller Button Clicked"));

        add(controllerButton);
    }

    private void addButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> createComponent(button.getText()));
        add(button);
    }

    private void addTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.addActionListener(e -> createComponent(textField.getText()));
        add(textField);
    }

    private void addTextView(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }

    private void createComponent(String componentName) {
        switch (componentName) {
            case "Button":
                JButton button = new JButton("New Button");
                addDragListeners(button);
                phoneInterface.add(button);
                break;
            case "TextField":
                JTextField textField = new JTextField("New TextField");
                addDragListeners(textField);
                phoneInterface.add(textField);
                break;
            case "Label":
                JLabel label = new JLabel("New Label");
                addDragListeners(label);
                phoneInterface.add(label);
                break;
        }

        phoneInterface.revalidate();
        phoneInterface.repaint();
    }

    private void addDragListeners(final Component component) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                offsetX = evt.getX();
                offsetY = evt.getY();
            }
        });

        component.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                int newX = evt.getXOnScreen() - offsetX;
                int newY = evt.getYOnScreen() - offsetY;

                // Ensure the component stays within the phone interface boundaries
                newX = Math.max(0, Math.min(phoneInterface.getWidth() - component.getWidth(), newX));
                newY = Math.max(0, Math.min(phoneInterface.getHeight() - component.getHeight(), newY));

                component.setLocation(newX, newY);
            }
        });
    }
}
