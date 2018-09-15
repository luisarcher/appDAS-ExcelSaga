package persistance.file.export;

import model.Sheet;

import java.io.File;

abstract class DocumentBuilder {

    protected Sheet model;
    protected File file;

    static DocumentBuilder getBuilder(String builderType){

        if (builderType.equalsIgnoreCase("csv")){
            return new CSVDocumentBuilder();
        }

        return null;
    }

    public DocumentBuilder setFile(File file){
        this.file = file;
        return this;
    }

    public DocumentBuilder setModel(Sheet model){
        this.model = model;
        return this;
    }

    abstract void save();

}
