package persistence.file.imports;

import java.io.File;

public class CSVFileImportAdapter extends FileLoad{

    CSVFileProperties csvFileProperties;

    public CSVFileImportAdapter(File file, CSVFileProperties csvFileProperties) {
        super(file);
        this.csvFileProperties = csvFileProperties;
    }

    @Override
    public String getValueSeparator() {

        return csvFileProperties.getValueDelimiter();
    }
}
