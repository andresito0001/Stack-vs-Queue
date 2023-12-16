package IOFile;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class FReader {
    public FReader(String path) {
        try {
            this.path = path;
            this.fileReader = new FileReader(path);
            this.buffer = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        String str = "";
        try {
            while ((str = this.buffer.readLine()) != null)
                System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLine(int line) {
        if (line <= 0) return null;
        String str = "";

        try {
            for (int i = 0; i < line - 1; i++)
                buffer.readLine();

            str = buffer.readLine();

            buffer.close();
            fileReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return str != null ? str : null;
    }
    
    public String getString() {
        StringBuilder sb = new StringBuilder();

        try {
            int ch;
            while ((ch = this.fileReader.read()) != -1) {
                sb.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String getPath() { return this.path; }

    private String path;
    private FileReader fileReader;
    private  BufferedReader buffer;
}
