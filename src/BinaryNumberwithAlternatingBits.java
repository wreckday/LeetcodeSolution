/**
 * Created by Mellon on 10/7/17.
 */
public class BinaryNumberwithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        int pre;
        pre = n & 1;
        n = n >> 1;
        while (n != 0) {
            int cur = n & 1;
            if (pre + cur != 1) return false;
            pre = cur;
            n = n >> 1;
        }
        return true;
    }



    public static void main(String[] args) {
        int input1 = 5;
        int input2 = 7;


        System.out.println(hasAlternatingBits(input2));

    }
}
