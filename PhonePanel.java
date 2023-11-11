import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;

class PhonePanel extends JPanel {
    private JPanel contentPanel;

    public PhonePanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 400));
        setBackground(Color.white);

        // Add phone image or any other representation
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setHorizontalAlignment(JLabel.CENTER);
        phoneLabel.setVerticalAlignment(JLabel.CENTER);
        add(phoneLabel, BorderLayout.NORTH);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Add mouse listener for block drop onto the phone
        DropTarget phoneDropTarget = new DropTarget(this, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent event) {
                Transferable transferable = event.getTransferable();
                if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    try {
                        String blockType = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                        Block newBlock = new Block(blockType);
                        contentPanel.add(newBlock);
                        contentPanel.revalidate();
                        contentPanel.repaint();
                        event.dropComplete(true);
                    } catch (Exception e) {
                        event.dropComplete(false);
                    }
                } else {
                    event.rejectDrop();
                }
            }
        });
        setDropTarget(phoneDropTarget);
    }

    public void clearContent() {
        contentPanel.removeAll();
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
