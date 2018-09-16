package persistence.file.imports;

import model.Sheet;
import persistence.file.utils.FileUtils;

import javax.swing.*;
import java.io.*;

public class FileImport {

    private Sheet model;
    private File file;

    public FileImport(Sheet model) {
        this.model = model;

        this.init();
        this.load();

    }

    private void init(){

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }

    private void load(){

        if (this.file == null) return;

        FileLoad loader = LoaderFactory.getLoader(FileUtils.getFileExtension(this.file),this.file);
        if (loader == null) return;
        loader.loadIntoModel(model);
    }


}
