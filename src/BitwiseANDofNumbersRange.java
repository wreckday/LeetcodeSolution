/**
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 For example, given the range [5, 7], you should return 4.

 * Created by Mellon on 10/2/16.
 */
public class BitwiseANDofNumbersRange {
    // find common prefix
    /*
    the bitwise and of the range is keeping the common bits of m and n from left to right
    until the first bit that they are different, padding zeros for the rest.
    * */
    public static int rangeBitwiseAnd(int m, int n) {
        int count=0;
        while(m!=n) {
            m=m>>>1; //shift numbers right
            n=n>>>1; //shift numbers right
            count=count+1; //keep track of Shifts
        }
        return n<<count; //do left shifts with 0 padding and return answer.
    }

    public static void main(String[] args){
        /*
            101
            110
            111
        */
        System.out.println(rangeBitwiseAnd(8, 11));
    }
}
