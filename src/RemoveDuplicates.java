/**
 * Created by Mellon on 2/19/15.
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] A) {
        // 1. index is the non-duplicate length
        if(A==null || A.length==0)
            return 0;
        // compare current element and next element, if they are not duplicate, assign A[index] with the non duplicate value.
        // and index ++
        int index=1;
        for(int i=1; i<A.length;i++){
            if(A[i]!=A[i-1]){
                A[index]=A[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] A = {1, 1, 1, 3, 3, 4, 5};
        System.out.println(removeDuplicates(A));
    }
}
