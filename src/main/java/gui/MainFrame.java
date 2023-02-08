package gui;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author juliomiguel
 */
public class MainFrame extends javax.swing.JFrame {
    
    Image icon = new ImageIcon(System.getProperty("user.dir")+ "/src/main/java/assets/search.png").getImage();
    
    private DefaultListModel availableSongsListModel;
    private DefaultListModel addedSongsListModel;

   
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
        String pdfsDir = System.getProperty("user.dir");
        File songsDirectory = new File(pdfsDir + "/pdfs");
        File[] pdfsSongs = songsDirectory.listFiles();
            
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDF Together");

        lblAvailablePdfs.setText("PDFs Disponíveis");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblAvailablePdfs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddedPdfs)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(lblArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblAddedPdfs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAvailablePdfs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lblSearchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> addedSongs;
    private javax.swing.JList<String> availableSongs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAddedPdfs;
    private javax.swing.JLabel lblArrowIcon;
    private javax.swing.JLabel lblAvailablePdfs;
    private javax.swing.JLabel lblSearchIcon;
    // End of variables declaration//GEN-END:variables
}

