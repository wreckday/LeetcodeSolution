/**
 Given an integer, write a function to determine if it is a power of three.
 Follow up:
 Could you do it without using any loop / recursion?
 *
 * Created by Mellon on 4/13/17.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double r = Math.log10(n) / Math.log10(3);
        return r%1==0;
    }
}
