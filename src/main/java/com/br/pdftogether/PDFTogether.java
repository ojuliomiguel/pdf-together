package com.br.pdftogether;

import com.br.pdftogether.gui.MainFrame;

/**
 *
 * @author juliomiguel
 */
public class PDFTogether {

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
