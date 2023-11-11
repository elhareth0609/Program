import java.awt.*;
import java.util.*;  // Import ArrayList
import java.util.List;       // Import List
import javax.swing.*;

class BlockListPanel extends JPanel {
    private List<Block> blocks;

    public BlockListPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(100, 500));
        setBackground(Color.lightGray);
        blocks = new ArrayList<>();

        // Add example blocks to the list
        addBlock("Variable");
        addBlock("Loop");
    }

    public void addBlock(String blockType) {
        Block block = new Block(blockType);
        blocks.add(block);
        add(block);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing between blocks
    }

    public Block removeBlock() {
        if (!blocks.isEmpty()) {
            Block removedBlock = blocks.remove(blocks.size() - 1);
            remove(removedBlock);
            revalidate();
            repaint();
            return removedBlock;
        }
        return null;
    }
}