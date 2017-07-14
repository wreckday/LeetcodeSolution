import java.util.*;
/**
 * Created by Mellon on 5/27/17.
 */
public class MinimumIndexSumofTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<list1.length;i++){
            map.put(list1[i], i);
        }

        int sum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int temp = map.get(list2[i]) + i;
                if(temp<sum){
                    sum = temp;
                    res = new ArrayList<>();
                    res.add(list2[i]);
                }else if(temp==sum){
                    res.add(list2[i]);
                }
            }
        }
        String[] finalResult = new String[res.size()];
        for(int i=0;i<res.size();i++){
            finalResult[i] = res.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args){
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Burger King", "Tapioca Express", "Shogun"};
        String[] res = findRestaurant(list1, list2);
        int v = 8;
    }
}
