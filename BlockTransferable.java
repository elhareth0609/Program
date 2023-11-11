import java.awt.datatransfer.*;
import java.io.*;

class BlockTransferable implements Transferable {
    private String blockType;

    public BlockTransferable(String blockType) {
        this.blockType = blockType;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.stringFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.stringFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(DataFlavor.stringFlavor)) {
            return blockType;
        }
        throw new UnsupportedFlavorException(flavor);
    }
}

