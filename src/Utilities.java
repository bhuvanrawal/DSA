import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bhuvan on 27/12/14.
 */
public class Utilities {
    public List giveArrayList(){
        Random r = new Random();
        List<Integer> newList = new ArrayList<Integer>();
        for (int i=0; i<100; i++){
            newList.add(r.nextInt());
        }
        return newList;
    }
}
