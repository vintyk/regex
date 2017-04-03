package Task18;
/**
 * Created by Vinty on 30.03.2017.
 */
public class Activity {
    private String type;
    private int time;
    public Activity(String type, int time) {
        this.type = type;
        this.time = time;
    }
    public String getType() {
        return type;
    }
    public int getTime() {
        return time;
    }
}
