import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 Given an array of citations (each citation is a non-negative integer) of a researcher,
 write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia:
 "A scientist has index h if h of his/her N papers have at least h citations each,
 and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5],
 which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each,
 his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 * Created by Mellon on 6/12/16.
 */
public class H_Index {
    /*      h-index (f) = max i min(f(i),i)}
    f(A)=10, f(B)=8, f(C)=5, f(D)=4, f(E)=3　→ h-index=4
    f(A)=25, f(B)=8, f(C)=5, f(D)=3, f(E)=3　→ h-index=3
    */

    public static int hIndex_Sort(int[] citations) {
        // nlogn
        if(citations==null||citations.length==0) return 0;

        Arrays.sort(citations);

        int max=0;
        for(int i=0;i<citations.length;i++){
            int index = citations.length-i;
            max = Math.max(max, Math.min(index, citations[i]));
        }
        return max;
    }


    public static void main(String[] args){
        int[] citations = {0};
        System.out.println(hIndex_Sort(citations));
    }
}
