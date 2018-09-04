package file.fileExport;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

class CSVDocumentBuilder extends DocumentBuilder{

    private final static Logger logger = Logger.getLogger(CSVDocumentBuilder.class);

    void save() {

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

            //System.out.println("CSV file was created successfully!");
            logger.debug("CSV file was created successfully!");

        } catch (Exception e) {
            //System.out.println("Error in CsvFileWriter!");
            e.printStackTrace();

            logger.debug("Error in CsvFileWriter: " + e.getMessage());

        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                //System.out.println("Error while flushing/closing fileWriter !!!");
                //e.printStackTrace();
                logger.debug("Error while flushing/closing fileWriter: " + e.getMessage());
            }
        }
    }
}
