package Task18;
import java.io.*;
import java.util.Scanner;
/**
 * Created by Vinty on 30.03.2017.
 */
public class FileUtils {
    public static void inFileWriteItAppend(String nameFile, String wrtItApp) {
        String filePath = Creatures.directory()+nameFile;
        String text = wrtItApp;
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    @Override
    public String toString() {
        return "FileUtils{}";
    }
}
