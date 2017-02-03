import java.util.*;

/**
 Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
 *
 * Created by Mellon on 9/27/16.
 */
public class L170_TwoSumIII_Datastructuredesign {

    public static void main(String[] args){
// Your TwoSum object will be instantiated and called as such:
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(0);
        twoSum.add(2);
        System.out.println(twoSum.find(3));
    }
}

class TwoSum{
    private Map<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, map.get(number)+1);
        }else
            map.put(number, 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {

        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            int diff = value - entry.getKey();
            if(map.containsKey(diff)){
                if(diff == entry.getKey()){
                    if(map.get(diff)>1)
                       return true;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
