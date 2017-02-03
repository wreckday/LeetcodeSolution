/**
 Given an integer, write a function to determine if it is a power of two.
 *
 * Created by Mellon on 10/16/16.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo2(int n) {
        if(n==0||n<0)   return false;
        if(n==1) return true;
        while(n%2==0){
            n=n>>1;
            if(n==1)
                return true;
        }
        return false;
    }
    //ex. 8
    // 1000
    // 8-1 = 7
    // 0111
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&n-1)==0;
    }
}
