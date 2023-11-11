import java.awt.*;
import javax.swing.*;

public class BlockProgrammingEnvironment {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Block Programming Environment");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            BlockListPanel blockListPanel = new BlockListPanel();
            PhonePanel phonePanel = new PhonePanel();

            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(blockListPanel, BorderLayout.WEST);
            frame.getContentPane().add(phonePanel, BorderLayout.CENTER);

            JButton clearButton = new JButton("Clear Phone");
            clearButton.addActionListener(e -> phonePanel.clearContent());
            frame.getContentPane().add(clearButton, BorderLayout.SOUTH);

            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
