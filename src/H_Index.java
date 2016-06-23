import java.util.Arrays;

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
    public static int hIndex(int[] citations) {
        //n2
        if(citations==null||citations.length==0) return 0;
        if(citations.length==1){
            if(citations[0]>0) return 1;
            else return 0;
        }

        int max=0;
        for(int i=0;i<citations.length;i++){
            int count = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=citations[i])
                    count++;
            }
            if(count>=citations[i])
                max = Math.max(citations[i], max);
            else
                max = Math.max(count, max);
        }
        return max;
    }

    public static int hIndex_Sort(int[] citations) {
        // nlogn
        if(citations==null||citations.length==0) return 0;
        if(citations.length==1){
            if(citations[0]>0) return 1;
            else return 0;
        }
        Arrays.sort(citations);

        int max=0;
        for(int i=0;i<citations.length;i++){
            if(citations.length-i>=citations[i])
                max = Math.max(citations[i], max);
            else
                max = Math.max(citations.length-i, max);
        }
        return max;
    }

    public static int hIndex_HashTable(int[] citations) {
        // nlogn
        if(citations==null||citations.length==0) return 0;
        if(citations.length==1){
            if(citations[0]>0) return 1;
            else return 0;
        }
        Arrays.sort(citations);

        int max=0;
        for(int i=0;i<citations.length;i++){
            if(citations.length-i>=citations[i])
                max = Math.max(citations[i], max);
            else
                max = Math.max(citations.length-i, max);
        }
        return max;
    }

    public static int hIndex_N(int[] citations) {
        /*
         After finalizing the counts vector,
         we can then easily locate his h-index by scanning from right (L) to left (0).
         By definition,
         index k is his h-index if the summation of all elements from counts[k] to counts[L] is no less than k.
        * */
        int L = citations.length;
        if(L<1) return 0;
        int[] counts = new int[L];
        for(int i : citations) {
            if(i>L) counts[L]++;
            else counts[i]++;
        }
        int res = 0;
        for(int k=L; k>=0; k--) {
            res += counts[k];
            if(res>=k) return k;
        }
        return 0;
    }

    public static void main(String[] args){
        int[] citations = {11, 15};
        System.out.println(hIndex(citations));
    }
}
