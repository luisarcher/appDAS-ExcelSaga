package persistence.file.export;

import model.Sheet;
import org.apache.log4j.Logger;

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
        if (saved != 0) {
            return;
        }

        this.file = getSelectedFileWithExtension(fileChooser);

    }

    private void build(){

        DocumentBuilder builder = DocumentBuilder.getBuilder(getFileExtension(this.file));
        builder
                .setFile(this.file)
                .setModel(this.model)
                .save();

    }

    private String getFileExtension(File file){

        return file.getName().split("\\.")[1];

    }

    private File getSelectedFileWithExtension(JFileChooser c) {
        File file = c.getSelectedFile();
        if (c.getFileFilter() instanceof FileNameExtensionFilter) {
            String[] exts = ((FileNameExtensionFilter)c.getFileFilter()).getExtensions();
            String nameLower = file.getName().toLowerCase();
            for (String ext : exts) { // check if it already has a valid extension
                if (nameLower.endsWith('.' + ext.toLowerCase())) {
                    return file; // if yes, return as is
                }
            }
            // if not, append the first extension from the selected filter
            file = new File(file.toString() + '.' + exts[0]);
        }
        return file;
    }


}
