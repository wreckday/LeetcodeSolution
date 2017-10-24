import java.util.Arrays;

/**
 * Created by Mellon on 10/17/17.
 */
public class Scramble {
    static void printScramble(String input) {
        if (input == null || input.length() == 0) return;
        char[] input_charArray = input.toCharArray(); //[B, A, T]
        Arrays.sort(input_charArray);
        helper(input_charArray, new boolean[input_charArray.length], new StringBuilder());
    }

    // 這裡用used[] 的原因是因為, result 是在乎順序的, 意思是{1, 2} 跟{2, 1} 是不一樣的
    // 其他backtracking 的題目有用start, 是因為題目是不在意順序的 {1, 2}, {2, 1} 是一樣的
    private static void helper(char[] input_charArray, boolean[] used, StringBuilder sb) {
        if (!sb.toString().equals("")) {
            // print
            System.out.println(sb.toString());

        }

        for (int i = 0; i < input_charArray.length; i++) {
            if (!used[i]) {
                if (i > 0 && !used[i - 1] && input_charArray[i - 1] == input_charArray[i]) continue;

                used[i] = true;
                sb.append(input_charArray[i]);
                helper(input_charArray, used, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        printScramble("BAT");
    }

}
