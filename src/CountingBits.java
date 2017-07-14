import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 Hint:

 You should make use of what you have produced already.Show More Hint

 * Created by Mellon on 4/2/16.
 */
public class CountingBits {
    //An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    /*
    For the the first solution : f[i] = f[i >> 1] + (i & 1) .
    This is more straight-forward. Right shit by 1 bit, compare to previously,
    the number of set bit would either reduce by 1(when number is odd) or no change(when number is even),
    that is why we add ( i & 1 ) which reflects whether the number is even or odd.
    * */
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static int[] countBits2(int num) {

        int[] old = new int[num+1];
        int oldSize = 1;
        old[0]=0;
        boolean flag = false;
        for(int i=0; i<32;i++){
            for(int j=0;j<oldSize;j++){
                if(oldSize+j>num){
                    flag = true;
                    break;
                }

                old[oldSize+j] = old[j]+1;
            }
            oldSize = oldSize*2;
            if(flag) break;
        }
        return old;
    }


    public static void main(String[] args){
        int num = 5;
        int[] result = countBits(5);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + ", ");
        }
    }
}
