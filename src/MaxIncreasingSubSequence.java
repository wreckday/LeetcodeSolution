import java.util.List;

/**
 * Created by Mellon on 7/4/15.
 */
public class MaxIncreasingSubSequence {
    public static int lis(int[] inputs){
        int[] msis = new int[inputs.length];
        for(int i=0;i<inputs.length;i++){
            msis[i] = inputs[i];
        }

        for(int i=0;i<inputs.length;i++){
            for(int j=0;j<i;j++){
                if(inputs[i] > inputs[j] && msis[j]+inputs[i]>msis[i]){
                    msis[i]=msis[j]+inputs[i];
                }
            }
        }
        int max = 0;
        for(int i=0;i<msis.length;i++){
            max = Math.max(max, msis[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] inputs = {1, 101, 2, 3, 100, 4, 5};
        System.out.print(lis(inputs));
    }
}
