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
    public static int[] countBits(int num) {

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
