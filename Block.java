import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;

class Block extends JPanel {
    private String blockType;

    public Block(String blockType) {
        this.blockType = blockType;
        setPreferredSize(new Dimension(100, 50));
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        JLabel label = new JLabel(blockType, JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        // Add mouse listeners for drag-and-drop
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(
                this, DnDConstants.ACTION_MOVE, new DragGestureListener() {
                    public void dragGestureRecognized(DragGestureEvent event) {
                        Transferable transferable = new BlockTransferable(blockType);
                        event.startDrag(null, transferable);
                    }
                });
    }

    public String getBlockType() {
        return blockType;
    }
}