import java.util.*;
/**
 * Created by Mellon on 9/16/17.
 */
public class MapSumPairs {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));

        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
    }


}

class MapSum {
    Map<String, Integer> map = new HashMap<>();

    public MapSum() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry entry :map.entrySet()){
            if(entry.getKey().toString().startsWith(prefix)){
                sum += (int)entry.getValue();
            }
        }
        return sum;
    }
}
