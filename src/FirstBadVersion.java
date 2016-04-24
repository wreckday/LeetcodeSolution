/**
 * Created by Mellon on 9/13/15.
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int l=1;
        int r=n;

        while(l<=r){
            int m = l + (r - l) / 2;
            if(isBadVersion(m))
                r=m-1;
            else
                l=m+1;
        }

        if(!isBadVersion(l))
            return -1;
        return l;
    }

    private static boolean isBadVersion(int version){
        boolean[] quality = {false, true, true, true, true};
        if(version>quality.length || version < 1)
            return true;
        return quality[version-1];
    }

    public static void main(String[] args){
        System.out.print(firstBadVersion(5));
    }
}
