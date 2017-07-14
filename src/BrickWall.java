import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * Created by Mellon on 4/9/17.
 */
public class BrickWall {
    public static int leastBricks(List<List<Integer>> wall) {
        for(List<Integer> row : wall){
            for(int i=0;i<row.size();i++){
                if(i>0){
                    row.set(i, row.get(i-1)+row.get(i));
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            for(int i=0;i<row.size()-1;i++){
                if(map.containsKey(row.get(i))){
                    map.put(row.get(i), map.get(row.get(i))+1);
                }else{
                    map.put(row.get(i), 1);
                }
            }
        }

        if(map.size()==0) return wall.size();

        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(entry.getValue()>=maxValue){
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        int rowsSize = wall.size();

        return rowsSize-maxValue;
    }

    public static void main(String[] args){
//        List<List<Integer>> input = new ArrayList<>();
//        List<Integer> row1 = Arrays.asList(1, 2, 2, 1);
//        List<Integer> row2 = Arrays.asList(3, 1, 2);
//        List<Integer> row3 = Arrays.asList(1, 3, 2);
//        List<Integer> row4 = Arrays.asList(2, 4);
//        List<Integer> row5 = Arrays.asList(3, 1, 2);
//        List<Integer> row6 = Arrays.asList(1, 3, 1, 1);
//        input.add(row1);
//        input.add(row2);
//        input.add(row3);
//        input.add(row4);
//        input.add(row5);
//        input.add(row6);


        List<List<Integer>> input = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1);
        List<Integer> row2 = Arrays.asList(1);
        List<Integer> row3 = Arrays.asList(1);
        input.add(row1);
        input.add(row2);
        input.add(row3);

        int res = leastBricks(input);
        System.out.println(res);
    }

}
