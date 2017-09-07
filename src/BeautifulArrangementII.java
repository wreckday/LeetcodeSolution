

/**
 * Created by Mellon on 9/4/17.
 */
public class BeautifulArrangementII {

    public static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int left = 1;
        int right = n;

        int index = 0;

        while (k > 0) {
            if (k % 2 == 0) {
                result[index] = left;
                index++;
                left++;
            } else {
                result[index] = right;
                index++;
                right--;
            }
            k--;
        }

        if (k % 2 == 1) {
            for (int i = left; i <= right; i++) {
                result[index++] = i;
            }
        } else {
            for (int i = right; i >= left; i--) {
                result[index++] = i;
            }
        }

        return result;
    }

    /*
這一題是array 的題目, 題目說給一個n(代表1, 2, ..., n)和一個k 只要求求出一個數組 與相鄰的絕對差值的個數必須等於k個, 一開始我想到的是暴力解法, 邊 recursion 邊求差, 得出結果, 但是超時了。
​
對於這一題有個很好的解法, 我們取最小值, 和最大值。剩下中間的數組, 照順序排列差值就是1。
例如：n=10, k=3
​
1, 10, 2, 3, 4, 5, 6, 7, 8, 9
(1) (2) (3) @ @ @ @ @ @ @
這個解法時間複雜度是n
    * */


    public static void main(String[] args) {
        Common.printIntegerArray(constructArray(10, 4));
    }
}
