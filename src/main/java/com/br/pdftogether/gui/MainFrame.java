package com.br.pdftogether.gui;

import com.br.pdftogether.service.PDFMergeService;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Main application window used to select and merge PDF files.
 */
public class MainFrame extends JFrame {

    private final DefaultListModel<File> availableModel = new DefaultListModel<>();
    private final DefaultListModel<File> addedModel = new DefaultListModel<>();
    private final File pdfsDir;

    private final JList<File> availableList = new JList<>(availableModel);
    private final JList<File> addedList = new JList<>(addedModel);
    private final JTextField searchField = new JTextField();
    private final JButton addButton = new JButton("Add");
    private final JButton removeButton = new JButton("Remove");
    private final JButton mergeButton = new JButton("Merge");
    private final JProgressBar progressBar = new JProgressBar();

    public MainFrame(File pdfsDir) {
        this.pdfsDir = pdfsDir;
        createUI();
        listPdfFiles();
        setLocationRelativeTo(null);
    }

    private void createUI() {
        setTitle("PDF Together");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel center = new JPanel(new BorderLayout());
        JPanel listsPanel = new JPanel(new java.awt.GridLayout(1, 2, 10, 0));

        JPanel left = new JPanel(new BorderLayout());
        left.add(searchField, BorderLayout.NORTH);
        left.add(new JScrollPane(availableList), BorderLayout.CENTER);

        JPanel right = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(removeButton);
        right.add(new JScrollPane(addedList), BorderLayout.CENTER);
        right.add(buttons, BorderLayout.SOUTH);

        listsPanel.add(left);
        listsPanel.add(right);

        center.add(listsPanel, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(mergeButton);
        bottom.add(progressBar);
        center.add(bottom, BorderLayout.SOUTH);

        add(center, BorderLayout.CENTER);
        pack();

        addButton.addActionListener(this::onAdd);
        removeButton.addActionListener(this::onRemove);
        mergeButton.addActionListener(this::onMerge);
        availableList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    onAdd(null);
                }
            }
        });

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void insertUpdate(DocumentEvent e) { filter(); }
        });
    }

    private void listPdfFiles() {
        File[] pdfs = pdfsDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
        if (pdfs == null) {
            return;
        }
        for (File pdf : pdfs) {
            availableModel.addElement(pdf);
        }
    }

    private void filter() {
        String text = searchField.getText().trim().toLowerCase();
        availableModel.clear();
        File[] pdfs = pdfsDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
        if (pdfs == null) return;
        for (File pdf : pdfs) {
            if (text.isEmpty() || pdf.getName().toLowerCase().contains(text)) {
                availableModel.addElement(pdf);
            }
        }
    }

    private void onAdd(ActionEvent e) {
        File selected = availableList.getSelectedValue();
        if (selected != null && !addedModel.contains(selected)) {
            addedModel.addElement(selected);
        }
    }

    private void onRemove(ActionEvent e) {
        int idx = addedList.getSelectedIndex();
        if (idx >= 0) {
            addedModel.remove(idx);
        }
    }


    private void onMerge(ActionEvent e) {
        if (addedModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select files to merge");
            return;
        }
        progressBar.setIndeterminate(true);
        mergeButton.setEnabled(false);
        new Thread(() -> {
            try {
                List<File> files = new ArrayList<>();
                for (int i = 0; i < addedModel.getSize(); i++) {
                    files.add(addedModel.getElementAt(i));
                }
                File out = new File(pdfsDir, "merged.pdf");
                new PDFMergeService().merge(files, out);
                Desktop.getDesktop().open(pdfsDir);
                JOptionPane.showMessageDialog(this, "Merge completed");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            } finally {
                SwingUtilities.invokeLater(() -> {
                    progressBar.setIndeterminate(false);
                    mergeButton.setEnabled(true);
                });
            }
        }).start();
    }
}
