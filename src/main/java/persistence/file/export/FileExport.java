package persistence.file.export;

import model.Sheet;
import org.apache.log4j.Logger;
import persistence.file.utils.FileUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileExport {

    private final static Logger logger = Logger.getLogger(FileExport.class);

    private JFileChooser fileChooser;
    private File file;
    private Sheet model;

    public FileExport(Sheet model){

        this.fileChooser = new JFileChooser();
        this.model = model;
        this.setup();
        this.init();
        this.build();

    }

    private void setup(){

        this.fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Document (*.csv)", "csv"));

    }

    private void init(){

        int saved = this.fileChooser.showSaveDialog(null);
        // User has chosen a file?
        if (saved != 0) {
            return;
        }

        this.file = FileUtils.getSelectedFileWithExtension(fileChooser);

    }

    private void build(){

        if (this.file == null) return;

        DocumentBuilder builder = DocumentBuilder.getBuilder(FileUtils.getFileExtension(this.file));
        builder
                .setFile(this.file)
                .setModel(this.model)
                .save();

    }
}
