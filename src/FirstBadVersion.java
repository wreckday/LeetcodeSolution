/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.


 *
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
