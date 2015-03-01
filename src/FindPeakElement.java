/**
 * Created by Mellon on 2/26/15.
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        //0535
        int l = 0;
        int r = num.length - 1;
        while(l <= r){
            if(l == r) return l;
            int mid = (l + r) / 2;
            if(num[mid] > num[mid + 1]){
                //find on the left
                r = mid;
            } else {
                //find on the right
                l = mid + 1;
            }
        }
        return r;
    }
}
