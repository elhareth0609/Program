import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;

import javax.swing.*;

class BlockPanel extends JPanel {
    public BlockPanel() {
        setLayout(null);  // Absolute positioning for blocks
        setPreferredSize(new Dimension(500, 500));

        // Add example blocks
        Block variableBlock = new Block("Variable");
        variableBlock.setBounds(50, 50, 100, 50);
        add(variableBlock);

        Block loopBlock = new Block("Loop");
        loopBlock.setBounds(200, 50, 100, 50);
        add(loopBlock);

        // Add mouse listener for block drop
        DropTarget blockDropTarget = new DropTarget(this, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent event) {
                Transferable transferable = event.getTransferable();
                if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    try {
                        String blockType = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                        Block newBlock = new Block(blockType);
                        Point dropPoint = event.getLocation();
                        newBlock.setBounds(dropPoint.x, dropPoint.y, 100, 50);
                        add(newBlock);
                        revalidate();
                        repaint();
                        event.dropComplete(true);
                    } catch (Exception e) {
                        event.dropComplete(false);
                    }
                } else {
                    event.rejectDrop();
                }
            }
        });
        setDropTarget(blockDropTarget);
    }
}
