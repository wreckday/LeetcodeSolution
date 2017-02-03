/**
 *
 Add Digits
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?

 Hint:

 A naive implementation of the above process is trivial. Could you come up with other methods?
 What are all the possible results?
 How do they occur, periodically or randomly?
 You may find this Wikipedia article useful.

 * Created by Mellon on 6/30/16.
 */
public class AddDigits {
/*
in  out  in  out
0   0    10  1
1   1    11  2
2   2    12  3
3   3    13  4
4   4    14  5
5   5    15  6
6   6    16  7
7   7    17  8
8   8    18  9
9   9    19  1
可以发现输出与输入的关系为：

out = (in - 1) % 9 + 1
*/
    public int addDigits2(int num) {
        return (num-1)%9+1;
    }

    public int addDigits(int num) {
        int value = num;
        while(value>9){
            value = digit(value);
        }
        return value;
    }

    private int digit(int num){

        int sum = 0;
        while(num>0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
}
