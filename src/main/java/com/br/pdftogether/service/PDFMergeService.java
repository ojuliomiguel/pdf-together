package com.br.pdftogether.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * Service responsible for merging PDF files using PDFBox
 */
public class PDFMergeService {

    /**
     * Merge the given PDF files to the destination path
     * @param pdfFiles list of PDF files to merge
     * @param destination destination file
     * @throws IOException in case of IO errors
     */
    public void merge(List<File> pdfFiles, File destination) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        merger.setDestinationFileName(destination.getAbsolutePath());
        for (File pdf : pdfFiles) {
            if (!pdf.exists()) {
                throw new FileNotFoundException(pdf.getAbsolutePath());
            }
            merger.addSource(pdf);
        }
        merger.mergeDocuments(null);
    }
}
