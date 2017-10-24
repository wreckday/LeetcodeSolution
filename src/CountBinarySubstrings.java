import java.util.List;

/**
 * Created by Mellon on 10/14/17.
 */
public class CountBinarySubstrings {

    public static int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int j = i + 1;
            count += getValidSubString(i, j, s);
        }
        return count;
    }

    private static int getValidSubString(int start, int end, String s) {
        int initStart = s.charAt(start);
        int initEnd = s.charAt(end);
        int count = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end) && initStart == s.charAt(start) && initEnd == s.charAt(end)) {
                start--;
                end++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "";
        System.out.println(countBinarySubstrings(input));

    }
}
