import java.util.*;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city
 * when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * <p>
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building,
 * respectively, and Hi is its height.
 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B)
 * in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment.
 * Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height
 * in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...]
 * is not acceptable;
 * the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * <p>
 * Created by Mellon on 6/23/16.
 */
public class TheSkylineProblem {
    /*
    for position in sorted(all start points and all end points)
       if this position is a start point
              add its height
       else if this position is a end point
              delete its height
       compare current max height with previous max height, if different, add
       current position together with this new max height to our result, at the
       same time, update previous max height to current max height;
    * */
    //  时间 O(n^2) 空间 O(N)   This is O(n^2) because removal in a PQ is O(n)
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] b : buildings) {
            // 確保start point 在 end point 之前處理 , 當position 位置一樣時
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        // 找出目前有影響力的矩形, 高度最高的。
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);  // 放入水平線

        /*
        必須要記得prev 最大的高度, 因為如果和現在的position 最大的高度一樣,
        代表之前的position with max 高度 已經加入結果集裡了
        * */
        int prev = 0;
        /*
        對每個position開始走（從最左邊開始往右邊）
        * */
        for (int[] h : height) {
            if (h[1] < 0) { //當前的position是start點, 加入矩形高度, 因為有可能會影響後面的position
                pq.offer(-h[1]);
            } else { // 當前的position 是end 點, 要移除矩形高度, 因為不會再影響後面的position了
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // 當前最大矩形高度會影響後面的position
            if (prev != cur) {    // 如果當前position最大的矩形高度, 跟前一個position 一樣,
                // 就不需要加入結果集合了, 因為之前一個position 的時候就加過了。反之, 則要！
                result.add(new int[]{h[0], cur});
                prev = cur;   // 前一個的position最大的高度,跟現在position最大高度不一樣, 所以要更新 prev 為當前最大高度
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        //int[][] buildings = {{2,9,10}, {3,11,7}};
        //int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
        //int[][] buildings = {{1,2,1},{2147483646,2147483647,2147483647}};
        //int[][] buildings = {{2,4,7},{2,4,5},{2,4,6}};
        //int[][] buildings = {{3, 10, 20}, {3, 9, 19}, {3, 8, 18}, {3, 7, 17}, {3, 6, 16}, {3, 5, 15}, {3, 4, 14}};
        //List<int[]> result2 = getSkyline2(buildings);
        List<int[]> result = getSkyline(buildings);

        int v = 5;
    }

    /*
    Sweepline is used in solving the problem. List<int[]> height is used to save each of the line segments including both start and end point. The trick here is to set the start segment as negative height. This has a few good uses:

first, make sure the start segment comes before the end one after sorting.

second, when pushing into the queue, it is very each to distinguish either to add or remove a segment.

lastly, when the two adjacent building share same start and end x value, the next start segment always come before due to the negative height, this makes sure that when we peek the queue, we always get the value we are supposed to get. When the first building is lower, when we peek the queue, we get the height of the second building, and the first building will be removed in the next round of iteration. When the second building is lower, the first peek returns the first building and since it equals to prev, the height will not be added.
    * */
}
