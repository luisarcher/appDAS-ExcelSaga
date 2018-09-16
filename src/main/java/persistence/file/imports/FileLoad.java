package persistence.file.imports;

import model.Sheet;

import java.io.*;

public class FileLoad implements IFileLoad{

    private File file;

    public FileLoad(File file) {
        this.file = file;
    }

    public String getValueSeparator(){
        return "\t";
    }

    public void loadIntoModel(Sheet model) {

        if (this.file == null) return;

        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            fis = new FileInputStream(file);

            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));
            String line;

            int i = 0;
            while ((line = br.readLine()) != null) {

                int j = 0;
                for (String _part : line.split(getValueSeparator())) {

                    model.setValueAt(_part, i, j);

                    ++j;
                }
                ++i;
            }

            // dispose all the resources after using them.
            fis.close();
            bis.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
