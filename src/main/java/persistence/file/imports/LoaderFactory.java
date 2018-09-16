package persistence.file.imports;

import java.io.File;

public class LoaderFactory {

    public static FileLoad getLoader(String type, File file){
        if (type.equalsIgnoreCase("csv")){
            return new CSVFileImportAdapter(file, new CSVFileProperties());
        }
        return null;
    }
}
