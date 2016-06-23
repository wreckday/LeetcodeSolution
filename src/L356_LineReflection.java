import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given n points on a 2D plane,
 * find if there is such a line parallel to y-axis that reflect the given set of points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n2)?

 Hint:

 Find the smallest and largest x-value for all points.
 If there is a line then it should be at y = (minX + maxX) / 2.
 For each point, make sure that it has a reflected point in the opposite side.
 *
 * Created by Mellon on 6/13/16.
 */
public class L356_LineReflection {
    public static boolean isReflected(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        // first pass, get the max, and min value of x
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] e:points){
            max = Math.max(e[0], max);
            min = Math.min(e[0], min);
            if(map.containsKey(e[0])){
                HashSet<Integer> set = map.get(e[0]);
                set.add(e[1]);
                map.put(e[0], set);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(e[1]);
                map.put(e[0], set);
            }

        }
        int sum = max+min;

        // second pass to see if each point has the symmetric point on the other side.
        for(int[] e:points){
            if(!map.containsKey(sum-e[0])||map.containsKey(sum-e[0])){
                HashSet<Integer> set = map.get(sum-e[0]);
                if(set==null || !set.contains(e[1]))
                    return false;
            }
        }
        return true;
    }
    /*
    Idea: Reflect the points by replacing every x with minX+maxX-x and then check whether you get the same points.
     Why minX+maxX-x? I actually thought of it as minX+(maxX-x),
     i.e., first the subtraction (maxX-x). That's how far x is away from the max,
     so instead go that distance from the min.
    */

    public static void main(String[] args){
        int[][] points = {{0,0},{1,0},{3,0}};
        System.out.print(isReflected(points));
    }
}
