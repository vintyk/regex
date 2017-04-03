package Task18;
/**
 * Created by Vinty on 30.03.2017.
 */
import java.util.ArrayList;
import java.util.List;
public class Lecture {
    private List <Activity> list ;
    public Lecture() {
        list = new ArrayList<Activity>();
    }
    public void add(Activity act){
        list.add(act);
    }
    public Integer getAllTime(){
        int rezalt = 0;
        for (int i = 0; i < list.size(); i++) {
            rezalt=rezalt+list.get(i).getTime();
        }
        System.out.println(list);
        return rezalt;
    }
    public List<Activity> getList() {
        return list;
    }
}
