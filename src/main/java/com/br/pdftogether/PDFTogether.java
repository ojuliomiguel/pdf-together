package com.br.pdftogether;

import com.br.pdftogether.gui.SelectPDFSFolderFrame;

/**
 *
 * @author juliomiguel
 */
public class PDFTogether {

    public static void main(String[] args) {
        try {
            configMacOSLookAndFeel();
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectPDFSFolderFrame().setVisible(true);
            }
        });
    }

    private static void configMacOSLookAndFeel() {
        System.setProperty("apple.awt.application.appearance", "system");
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("sun.java2d.uiScale.enabled", "true");
        System.setProperty("apple.awt.graphics.UseQuartz", "true");
    }
}
