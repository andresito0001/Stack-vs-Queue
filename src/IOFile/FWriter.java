package IOFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FWriter {
    public FWriter(String path, String fileName) { 
        this.fileName = fileName;
        this.path = path + fileName;
        
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile(String message) {
        try {
            FileWriter fileWriter = new FileWriter(this.path, true);

            for (char ch : message.toCharArray())
                fileWriter.write(ch);
            
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() { return this.fileName; }
    
    private String path;
    private String fileName;
}
