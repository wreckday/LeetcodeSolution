/**
 * Created by Mellon on 6/12/16.
 */
public class H_index2 {
    public static int hIndex(int[] citations) {
        int left=0, len = citations.length, right= len-1,  mid;
        while(left<=right)
        {
            mid=(left+right)>>1;
            if(citations[mid]== (len-mid)) return citations[mid];
            else if(citations[mid] > (len-mid)) right = mid - 1;
            else left = mid + 1;
        }
        return len - (right+1);
    }
}
