/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 * <p>
 * Created by Mellon on 10/11/17.
 */
public class DivideTwoIntegers {
    /*
    这道题属于数值处理的题目，对于整数处理的问题，比较重要的注意点在于符号和处理越界的问题。
    对于这道题目，因为不能用乘除法和取余运算，我们只能使用位运算和加减法。
    比较直接的方法是用被除数一直减去除数，直到为0。这种方法的迭代次数是结果的大小，即比如结果为n，算法复杂度是O(n)。

    那么有没有办法优化呢？ 这个我们就得使用位运算。
    我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，即num = a_0*2^0 + a_1*2^1 + a_2*2^2 +...+ a_n*2^n。
    基于以上这个公式以及左移一位相当于乘以2，我们先让除数左移直到大于被除数之前得到一个最大的基。
    然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。
    因为这个方法的迭代次数是按2的幂直到超过结果，所以时间复杂度为O(logn)。代码如下：
    * */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = dividend;
        long b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        while (a >= b) {
            long t = b;
            for (int i = 1; a >= t; i <<= 1, t <<= 1) {
                a -= t;
                res += i;
            }
        }
        // a is mod
        // res is quotation
        return ((dividend < 0) ^ (divisor < 0)) ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(divide(27, 3));

    }
}
