import java.util.Arrays;

/**
 Design and implement a data structure for a compressed string iterator.
 It should support the following operations: next and hasNext.

 The given compressed string will be in the form of each letter followed by
 a positive integer representing the number of this letter existing in the original uncompressed string.

 next() - if the original string still has uncompressed characters, return the next letter;
    Otherwise return a white space.
 hasNext() - Judge whether there is any letter needs to be uncompressed.

 Note:
 Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

 Example:

 StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

 iterator.next(); // return 'L'
 iterator.next(); // return 'e'
 iterator.next(); // return 'e'
 iterator.next(); // return 't'
 iterator.next(); // return 'C'
 iterator.next(); // return 'o'
 iterator.next(); // return 'd'
 iterator.hasNext(); // return true
 iterator.next(); // return 'e'
 iterator.hasNext(); // return false
 iterator.next(); // return ' '
 */
public class DesignCompressedStringIterator {
    public static void main(String[] args){
        String compressedString = "L1e2t1C1o1d1e1"; // LeetCode
        StringIteratorOnDemand iterator = new StringIteratorOnDemand(compressedString);
        iterator.next();
    }
}

/*
The space required for storing the results of the precomputation is O(n),
where n refers to the length of the compressed string.
The nums and chars array contain a total of n elements.

The precomputation step requires O(n) time.

Once the precomputation has been done, hasNext() and next() requires O(1) time
* */
class StringIterator {
    int ptr = 0;
    String[] chars;
    int[] nums;
    public StringIterator(String compressedString) {
        // get count by separate by a-zA-Z
        String[] numsString = compressedString.substring(1).split("[a-zA-Z]+");
        // convert array of string to array of integer
        nums = Arrays.stream(compressedString.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();

        // get char by separating 0-9
        chars = compressedString.split("[0-9]+");
    }
    public char next() {
        if (!hasNext())
            return ' ';
        nums[ptr]--;
        // string to char
        char res = chars[ptr].charAt(0);
        if(nums[ptr]==0)
            ptr++;
        return res;
    }
    public boolean hasNext() {
        return ptr != chars.length;
    }
}


/*
Since no precomputation is done, constant space is required in this case.

The time required to perform next() operation is O(1).

The time required for hasNext() operation is O(1).

Since no precomputations are done, and hasNext() requires only O(1) time, this solution is advantageous if hasNext() operation is performed most of the times.

This approach can be extended to include previous() and hasPrevious() operationsm, but this will require the use of some additional variables.
* */
class StringIteratorOnDemand {
    String res;
    int ptr = 0, num = 0;
    char ch = ' ';
    public StringIteratorOnDemand(String s) {
        res = s;
    }
    public char next() {
        if (!hasNext())
            return ' ';
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                num = num * 10 + res.charAt(ptr++) - '0';
            }
        }
        num--;
        return ch;
    }
    public boolean hasNext() {
        return ptr != res.length() || num != 0;
    }
}
