import java.util.*;

/**
 Remove the minimum number of invalid parentheses in order to make the input string valid.
 Return all possible results.
 Note: The input string may contain letters other than the parentheses ( and ).
 Examples:
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]

 *
 * Created by Mellon on 2/5/17.
 */
public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParenthesesBFS(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }
            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

    // helper function checks if string s contains valid parantheses
    static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')'){
                if(count==0) return false;
                count--;
            }
        }
        return count == 0;
    }


    /*
    Here I share my DFS or backtracking solution. It's 10X faster than optimized BFS.

    Limit max removal rmL and rmR for backtracking boundary.
    Otherwise it will exhaust all possible valid substrings, not shortest ones.
    Scan from left to right, avoiding invalid strs (on the fly) by checking num of open parens.
    If it's '(', either use it, or remove it.
    If it's '(', either use it, or remove it.
    Otherwise just append it.
    Lastly set StringBuilder to the last decision point.
    In each step, make sure:

    i does not exceed s.length().
    Max removal rmL rmR and num of open parens are non negative.
    De-duplicate by adding to a HashSet.
    Compared to 106 ms BFS (Queue & Set), it's faster and easier. Hope it helps! Thanks.
    */
    public static List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, "", rmL, rmR, 0);
        return new ArrayList<>(res);
    }

    public static void dfs(String s, int i, Set<String> res, String buildString, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(buildString.toString());
            }
            return;
        }

        char c = s.charAt(i);

        if (c == '(') {
            dfs(s, i + 1, res, buildString, rmL - 1, rmR, open);		    // not use (
            dfs(s, i + 1, res, buildString + c, rmL, rmR, open + 1);       // use (
        } else if (c == ')') {
            dfs(s, i + 1, res, buildString, rmL, rmR - 1, open);	            // not use  )
            dfs(s, i + 1, res, buildString + c, rmL, rmR, open - 1);  	    // use )
        } else {
            dfs(s, i + 1, res, buildString + c, rmL, rmR, open);
        }
    }


    public static void main(String[] args){
        String input = "()())()";
        List<String> minValidResult = removeInvalidParenthesesBFS(input);
        List<String> minValidResult2 = removeInvalidParentheses(input);
        int v = 5;
    }
}
