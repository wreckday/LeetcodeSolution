import java.util.Stack;

/**
 * Created by Mellon on 3/12/17.
 */
public class ConstructBinaryTreefromString {
    public TreeNode str2tree(String s) {
        final int n = s.length();
        if (n == 0) return null;

        TreeNode dummy = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(dummy);

        int i = 0;
        TreeNode last;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '-' || Character.isDigit(ch)) {
                int sign = 1;
                if (ch == '-') {
                    sign = -1;
                    i++;
                }
                int sum = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    sum = 10*sum + s.charAt(i) - '0';
                    i++;
                }
                last = new TreeNode(sign * sum);
                if (stack.peek().left == null) {
                    stack.peek().left = last;
                } else {
                    stack.peek().right = last;
                }
                stack.push(last);
                continue;
            }

            if (ch == ')') {
                stack.pop();
            }
            i++;
        }
        return dummy.left;

        //return construct(s, 0, n-1);
    }
}
