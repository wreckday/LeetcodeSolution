/**
 * Created by Mellon on 2/21/15.
 */
public class NextPermutation {
    // http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
    public static void nextPermutation(int[] num) {

        if(num==null || num.length==0)
            return;

        // 1. from left to right, find the first digit violate the increase trend (partition number i)
        int i = num.length-2;
        while(i>=0 && num[i]>=num[i+1]){
            i--;
        }

        // point: check i>=0
        if(i>=0){
            // 2. from right to left, find the first digit which larger than partition number and call it change number j
            int j=num.length-1;
            while(j>i && num[j]<=num[i])
                j--;

            // 3. swap the i and j
            int temp = num[j];
            num[j]=num[i];
            num[i]=temp;
        }
        // 4. reverse all the digits on the right of i
        reverse(num, i+1);
    }
    private static void reverse(int[] num, int index)  {
        int l = index;
        int r = num.length-1;
        while(l<r)
        {
            int temp = num[l];
            num[l] = num[r];
            num[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args){
        int[] a = {2,3,6,5,4,1};
        nextPermutation(a);
        for(int e : a){
            System.out.print(e+",");
        }
    }
}
