package Task18;
/**
 * Created by Vinty on 30.03.2017.
 */
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Time {
    public static int timeMinusTime(String time1, String time2){
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        LocalTime mm = LocalTime.parse(time1, formatter);
        LocalTime mm2 = LocalTime.parse(time2, formatter);
        int calc = (mm.getHour()*60+mm.getMinute())-(mm2.getHour()*60+mm2.getMinute());
        return calc;
    }
}
