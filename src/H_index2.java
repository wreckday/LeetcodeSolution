/**
 * Created by Mellon on 6/12/16.
 */
public class H_index2 {
    public static int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length-1;
        int index;
        int max = 0;
        while(l<=r){
            int mid = (l+r)/2;
            index = citations.length-mid;

            if(citations[mid] >= index){
                r = mid-1;
                max = Math.max(max, index);
            }else{
                l = mid+1;
                max = Math.max(max, citations[mid]);
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] citations = {3, 4, 5, 8, 10};
        int[] citations2 = {100};
        int[] citations3 = {11, 15};
        int[] citations4 = {0, 0, 4, 4};
        System.out.println(hIndex(citations2));
    }
}
