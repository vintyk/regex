package Task18;
/**
 * Created by Vinty on 30.03.2017.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainStart {
    public static String nameFileLog = "log.txt";
    public static String nameFile1 = "time_period.txt";
    public static String nameFile2 = "total_time.txt";
    public static void main(String[] args) {
        Scanner scanner = null;
        List<Break> br = new ArrayList<Break>();
        List<Decision> dec = new ArrayList<Decision>();
        List<Exersise> ex = new ArrayList<Exersise>();
        List<Lecture> lec = new ArrayList<Lecture>();
        Lecture lecOb = new Lecture();
        Break brOb = new Break();
        Decision decOb = new Decision();
        Exersise exOb = new Exersise();
        Boolean isFirst = true;
        int clearTime = 0;
        String tempGroup1 = "";
        String tempGroup2 = "";
        String type = "";
        String tempActivity = "";
        File directory = new File(Creatures.directory());
        File file = new File(directory, nameFileLog);
        File resultFile1 = new File(directory, nameFile1);
        File resultFile2 = new File(directory, nameFile2);
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            Pattern pattern = Pattern.compile("(\\d{2}:\\d{2})(.*)");
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                if (isFirst) {
                    tempGroup1 = matcher.group(1);
                    tempActivity = matcher.group(2);
                    type = matcher.group(2);
                    isFirst = false;
                } else {
                    FileUtils.inFileWriteItAppend(nameFile1, tempGroup1 + " " + matcher.group(1) + " " + tempActivity + "\n");
                    tempActivity = matcher.group(2);
                    tempGroup2 = matcher.group(1);
                    if (tempActivity.toLowerCase().contains("конец")){
                        FileUtils.inFileWriteItAppend(nameFile1, "\n");
                    }
                    clearTime = Time.timeMinusTime(tempGroup2, tempGroup1);
                    isFirst = false;
                    if (type.toLowerCase().contains("веден")
                            || type.toLowerCase().contains("скаляр")
                            || type.toLowerCase().contains("массив")) {
                        lecOb.add(new Activity(type, clearTime));
                    } else if (type.toLowerCase().contains("перерыв")) {
                        brOb.add(new Activity(type, clearTime));
                    } else if (type.toLowerCase().contains("решения")) {
                        decOb.add(new Activity(type, clearTime));
                    } else if (type.toLowerCase().contains("упражнения")) {
                        exOb.add(new Activity(type, clearTime));
                    }
                    tempGroup1 = tempGroup2;
                    type = matcher.group(2);
                }
            } else {
                isFirst = true;
                Double allTime = (double) ((double) ((lecOb.getAllTime() + brOb.getAllTime() + decOb.getAllTime()
                        + exOb.getAllTime())) / 100);
                FileUtils.inFileWriteItAppend(nameFile2, lecOb.getClass().getSimpleName() + ": " + lecOb.getAllTime()
                        + " минут " + (int) (lecOb.getAllTime() / allTime) + "% " + "\n");
                FileUtils.inFileWriteItAppend(nameFile2, brOb.getClass().getSimpleName() + ": " + brOb.getAllTime()
                        + " минут " + (int) (brOb.getAllTime() / allTime) + "% " + "\n");
                FileUtils.inFileWriteItAppend(nameFile2, decOb.getClass().getSimpleName() + ": " + decOb.getAllTime()
                        + " минут " + (int) (decOb.getAllTime() / allTime) + "% " + "\n");
                FileUtils.inFileWriteItAppend(nameFile2, exOb.getClass().getSimpleName() + ": " + exOb.getAllTime()
                        + " минут " + (int) (exOb.getAllTime() / allTime) + "% " + "\n");
                FileUtils.inFileWriteItAppend(nameFile2, "Лекции:\n");
                for (int i = 0; i < lecOb.getList().size(); i++) {
                    FileUtils.inFileWriteItAppend(nameFile2,
                            lecOb.getList().get(i).getType() + ": " + lecOb.getList().get(i).getTime() + " минут "
                                    + (int) (lecOb.getList().get(i).getTime() / allTime) + "% " + "\n");
                }
                lec.add(lecOb);
                br.add(brOb);
                dec.add(decOb);
                ex.add(exOb);
                lecOb = new Lecture();
                brOb = new Break();
                decOb = new Decision();
                exOb = new Exersise();
                FileUtils.inFileWriteItAppend(nameFile2, "\n");
            }
        }
    }
}
