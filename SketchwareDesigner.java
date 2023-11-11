import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SketchwareDesigner extends JFrame {
    private JPanel canvas;
    private JPanel phone;
    private JPanel phonepanel;
    private JPanel page;

    public SketchwareDesigner() {
        setTitle("Sketchware Designer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Assuming you are using a null layout for the frame

        canvas = new JPanel();
        phone = new JPanel();
        phonepanel = new JPanel();
        page = new JPanel();

        canvas.setLayout(null);
        canvas.setBackground(Color.white);

        // Create example blocks
        createBlock("TextFiled", 0, 50);
        createBlock("Text", 0, 100);
        createBlock("Image", 0, 150);

        page.setBounds(0, 0, 800, 50);
        page.setBackground(Color.blue);

        phonepanel.setBounds(100, 50, 700, 400);
        phonepanel.setLayout(null); // Assuming you are using a null layout for phonepanel
        phonepanel.setBackground(Color.red);

        phone.setBackground(Color.green);
        phone.setBounds(175, 100, 350, 400);

        setContentPane(canvas);
        add(phonepanel);
        add(page);
        phonepanel.add(phone);

        setVisible(true);
    }

    private void createBlock(String label, int x, int y) {
        JLabel block = new JLabel(label);
        block.setBounds(x, y, 100, 50);
        block.setOpaque(true);
        block.setBackground(Color.lightGray);
        block.setHorizontalAlignment(SwingConstants.CENTER);

        // Add mouse listeners for drag-and-drop
        addDragListeners(block);

        canvas.add(block);
    }

    private void addDragListeners(final JLabel label) {
        // Use an array to store offsetX and offsetY
        final int[] offset = new int[2];

                label.addMouseListener(new MouseAdapter() {
            @Override


            public void mousePressed(MouseEvent e) {
                offset[0] = e.getX();
                offset[1] = e.getY();
                
                JLabel copy = new JLabel(label.getText());
                copy.setBounds(label.getBounds());
                copy.setOpaque(true);
                copy.setBackground(Color.lightGray);
                copy.setHorizontalAlignment(SwingConstants.CENTER);
        
                // Add drag listeners to the copy
                addDragListeners(copy);
        
                // Add the copy to the canvas
                canvas.add(copy);
                canvas.revalidate();
                canvas.repaint();
        
                // Move the copy to the cursor position
                label.setLocation(e.getXOnScreen() - offset[0], e.getYOnScreen() - offset[1]);
            }
        });
        

        label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - offset[0];
                int newY = e.getYOnScreen() - offset[1];

                // Ensure the label stays within the canvas boundaries
                newX = Math.max(0, Math.min(canvas.getWidth() - label.getWidth(), newX));
                newY = Math.max(0, Math.min(canvas.getHeight() - label.getHeight(), newY));

                label.setLocation(newX, newY);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SketchwareDesigner();
        });
    }
}
