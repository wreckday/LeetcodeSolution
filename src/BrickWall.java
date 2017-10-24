import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * Created by Mellon on 4/9/17.
 */
public class BrickWall {
    public static int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
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
