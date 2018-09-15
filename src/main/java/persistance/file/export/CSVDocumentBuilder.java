package persistance.file.export;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

class CSVDocumentBuilder extends DocumentBuilder{

    private final static Logger logger = Logger.getLogger(CSVDocumentBuilder.class);

    void save() {

        if (this.model == null || this.file == null)
            return;

        logger.debug("Saving file: " + this.file.getPath());

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.file);

            for (int i = 0; i < model.getRowCount(); i++){

                for (int j = 0; j < model.getColumnCount(); j++){

                    fileWriter.append(model.getValueAt(i,j).getValue());
                    fileWriter.append(",");

                }

                fileWriter.append("\n");

            }

            logger.debug("CSV file was created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error in CsvFileWriter: " + e.getMessage());

        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.debug("Error while flushing/closing fileWriter: " + e.getMessage());
            }
        }
    }
}
