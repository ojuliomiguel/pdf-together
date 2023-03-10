package gui;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 *
 * @author juliomiguel
 */
public class MainFrame extends javax.swing.JFrame {
    
    Image icon = new ImageIcon(System.getProperty("user.dir")+ "/src/main/java/assets/search.png").getImage();
    
    private DefaultListModel<String> availableSongsListModel;
    private DefaultListModel<String> addedSongsListModel;
    private File songsDirectory = new File(System.getProperty("user.dir") + "/pdfs");
   
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setDefaultModelToListsComponents();
        this.listPdfFiles();
        this.lblSearchIcon.setIcon(new ImageIcon(icon));
    }
    
    private void listPdfFiles() {
        File[] pdfsSongs = this.songsDirectory.listFiles();
            
        for (File pdfSong : pdfsSongs) {
            this.availableSongsListModel.addElement(pdfSong.getName());
        }   
    }
    
    private void setDefaultModelToListsComponents() {
        this.availableSongsListModel = new DefaultListModel();
        this.addedSongsListModel = new DefaultListModel();
        this.availableSongs.setModel(availableSongsListModel);
        this.addedSongs.setModel(addedSongsListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAvailablePdfs = new javax.swing.JLabel();
        lblAddedPdfs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableSongs = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        addedSongs = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        lblSearchIcon = new javax.swing.JLabel();
        lblArrowIcon = new javax.swing.JLabel();
        bntMergePdfs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDF Together");

        lblAvailablePdfs.setText("PDFs Dispon??veis");

        lblAddedPdfs.setText("PDFs Adicionados");

        availableSongs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                availableSongsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(availableSongs);

        addedSongs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addedSongsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(addedSongs);

        jTextField1.setText("pesquisar");

        lblSearchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchIconMouseClicked(evt);
            }
        });

        bntMergePdfs.setText("Juntar");
        bntMergePdfs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntMergePdfsMouseClicked(evt);
            }
        });
        bntMergePdfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntMergePdfsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblAvailablePdfs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddedPdfs)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntMergePdfs)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddedPdfs)
                    .addComponent(lblAvailablePdfs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(lblArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntMergePdfs))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSearchIconMouseClicked

    private void addedSongsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addedSongsKeyPressed
        boolean deleteKeyPressed = evt.getKeyCode() == KeyEvent.VK_DELETE;
        if (deleteKeyPressed) {
            int selectedIndex = addedSongs.getSelectedIndex();
            if (selectedIndex != -1) {
                this.addedSongsListModel.remove(selectedIndex);
            }
        }
        
    }//GEN-LAST:event_addedSongsKeyPressed

    private void availableSongsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_availableSongsValueChanged
        if (!evt.getValueIsAdjusting()) {
            this.addedSongsListModel.addElement(
                this.availableSongs.getSelectedValue()
            );
        }
    }//GEN-LAST:event_availableSongsValueChanged

    private void bntMergePdfsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntMergePdfsMouseClicked
        PDFMergerUtility PDFMerger = new PDFMergerUtility();
        String PDFDestination = System.getProperty("user.dir") + "mergedPDF.pdf";
        PDFMerger.setDestinationFileName(PDFDestination);
        for (int i = 0; i < this.addedSongsListModel.getSize(); i++) {
            String pdfName = this.addedSongsListModel.getElementAt(i);
            String filePath = this.songsDirectory + "/" + pdfName;
            try {
                PDFMerger.addSource(filePath);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            PDFMerger.mergeDocuments();
            JOptionPane.showMessageDialog(null, "PDFs juntados com sucesso!");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntMergePdfsMouseClicked

    private void bntMergePdfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntMergePdfsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntMergePdfsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> addedSongs;
    private javax.swing.JList<String> availableSongs;
    private javax.swing.JButton bntMergePdfs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAddedPdfs;
    private javax.swing.JLabel lblArrowIcon;
    private javax.swing.JLabel lblAvailablePdfs;
    private javax.swing.JLabel lblSearchIcon;
    // End of variables declaration//GEN-END:variables
}

