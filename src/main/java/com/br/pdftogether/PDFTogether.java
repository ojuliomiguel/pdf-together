package com.br.pdftogether;

import com.br.pdftogether.gui.SelectPDFSFolderFrame;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author juliomiguel
 */
public class PDFTogether {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new SelectPDFSFolderFrame().setVisible(true));
    }
}
