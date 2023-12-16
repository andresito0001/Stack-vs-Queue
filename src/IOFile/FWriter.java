package IOFile;
import java.io.FileWriter;
import java.io.IOException;

public class FWriter {
    FWriter(String message) { 
        this.message = message;
    }

    public void writeFile(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);

            for (char ch : message.toCharArray()) {
                fileWriter.write(ch);
            }
            
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String message;
}
