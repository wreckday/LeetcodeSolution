/**
 * Your task is to calculate ab mod 1337 where a is a positive integer
 * and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 *
 * Created by Mellon on 7/29/16.
 */
public class SuperPow {
    //O(n)
    public static int superPow(int a, int[] b) {
        int result = 1;
        for(int i=0;i<b.length;i++){
            result = pow(result, 10, 1337) * pow(a, b[i], 1337)%1337;
        }

        return result;
    }

    public static int pow(int a, int b, int c){
        int i=0;
        long result = 1;
        long p = a;
        while(i<b){
            result = result * p%c;
            i++;
        }
        return (int)result%c;
    }

    public static int pow2(int a, int b, int c) {
        long res = 1;
        long p = a;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * p) % c;
            }
            p = (p * p) % c;
            b >>= 1;
        }
        return (int)(res % c);
    }
/*
    def superPow(self, a, b):
    result = 1
            for digit in b:
    result = pow(result, 10, 1337) * pow(a, digit, 1337) % 1337
            return result
*/
    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(superPow(a, b));
    }

}
