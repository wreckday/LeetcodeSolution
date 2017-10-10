/**
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.
 *
 * Created by Mellon on 10/3/17.
 */
public class LargestRectangleinHistogram {
    public static int largestRectangleAreaDQ(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        return maxArea(A, 0, A.length - 1);
    }

    static int maxArea(int[] A, int l, int r) {
        if (l == r)
            return A[l];
        int m = l + (r - l) / 2;
        int area = maxArea(A, l, m);
        area = Math.max(area, maxArea(A, m + 1, r));
        area = Math.max(area, maxCombineArea(A, l, m, r));
        return area;
    }


    static int maxCombineArea(int[] A, int l, int m, int r) {
        int i = m, j = m + 1;
        int area = 0, h = Math.min(A[i], A[j]);
        while (i >= l && j <= r) {
            h = Math.min(h, Math.min(A[i], A[j]));
            area = Math.max(area, (j - i + 1) * h);
            if (i == l)
                ++j;
            else if (j == r)
                --i;
            else {
                if (A[i - 1] > A[j + 1])
                    --i;
                else
                    ++j;
            }
        }
        return area;
    }

    public static void main(String[] args){
        int[] heights = {2,1,5,6,2,3};
        largestRectangleAreaDQ(heights);

    }
}
