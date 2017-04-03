package Task18;
import java.io.File;
import java.io.IOException;
/**
 * Created by Vinty on 30.03.2017.
 */
public class Creatures {
    public static String directory(){
        String absoluterFilePath;
        String workingDirectory = System.getProperty("user.dir");
        absoluterFilePath = workingDirectory + File.separator + "src" + File.separator + "Task18" + File.separator;
        return absoluterFilePath;
    }
    public static void crtFile(String nameFile) throws IOException {
        String fileName = nameFile;
        String absolutFilePath = directory() + nameFile;
        File file = new File(absolutFilePath);
        if (file.createNewFile()) {
            System.out.println("File is created. Path = " + absolutFilePath);
        } else {
            System.out.println("File " + fileName + " already exist. We will resign it!");
        }
    }
    @Override
    public String toString() {
        return "Creatures{}";
    }
}