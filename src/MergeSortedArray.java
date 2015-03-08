/**
 * Created by Mellon on 2/22/15.
 *
 Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note:
 You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0&&j>=0){
            if(A[i]>=B[j]){
                A[k] = A[i];
                i--;
            }else{
                A[k] = B[j];
                j--;
            }
            k--;
        }

        while(j>=0){
            A[k]=B[j];
            j--;
            k--;
        }
    }
}
