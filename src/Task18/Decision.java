package Task18;
/**
 * Created by Vinty on 30.03.2017.
 */
import java.util.ArrayList;
import java.util.List;
public class Decision {
    private List <Activity> list ;
    public Decision() {
        list = new ArrayList<Activity>();
    }
    public void add(Activity act){
        list.add(act);
    }
    public Integer getAllTime(){
        int rezalt = 0;
        for (int i = 0; i < list.size(); i++) {
            rezalt+=list.get(i).getTime();
        }
        return rezalt;
    }
}