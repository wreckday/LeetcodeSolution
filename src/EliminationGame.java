import java.util.ArrayList;
import java.util.TreeSet;

/**
 There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

 Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

 We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

 Find the last number that remains starting with a list of length n.

 Example:

 Input:
 n = 9,
 1 2 3 4 5 6 7 8 9
 2 4 6 8
 2 6
 6

 Output:
 6
 *
 * Created by Mellon on 10/29/16.
 */
public class EliminationGame {
   /*   O(logN)
    My idea is to update and record head in each turn. when the total number becomes 1, head is the only number left.
    When will head be updated?
    if we move from left
    if we move from right and the total remaining number % 2 == 1
    like 2 4 6 8 10, we move from 10, we will take out 10, 6 and 2, head is deleted and move to 4
    like 2 4 6 8 10 12, we move from 12, we will take out 12, 8, 4, head is still remaining 2
   */

    public static int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static int lastRemainingslow(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        boolean left = true;
        while(list.size()>1){
            if(left){  // from left to right
                for(int i=0;i<list.size();i++){
                    list.remove(i);
                }
            }else{ // from right to left
                int i=0;
                while(list.size()>1 && list.size()-1-i>=0){
                    list.remove(list.size()-1-i);
                    i++;
                }
            }
            left=!left;
        }
        return list.size()>0?list.get(0):0;
    }

    public static void main(String[] args){
        System.out.println(lastRemaining(0));
    }
}
