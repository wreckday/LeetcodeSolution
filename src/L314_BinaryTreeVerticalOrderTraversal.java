import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * <p>
 * Created by Mellon on 3/13/17.
 */
public class L314_BinaryTreeVerticalOrderTraversal {
    /*
    Time Complexity - O(n)，
    Space Complexity - O(n)

    BFS, put node, col into queue at the same time
    Every left child access col - 1 while right child col + 1
    This maps node into different col buckets
    Get col boundary min and max on the fly
    Retrieve result from cols

    * */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // map 的key 是存第幾行col, value 是 所有元素在那個col 裡的元素
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // queue 是用BFS來遍歷樹的
        Queue<TreeNode> q = new LinkedList<>();
        // 這個queue是用來跟另外一個queue做對應的
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0;  // 最左邊的行數
        int max = 0;  // 最右邊的行數

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }


    public static void main(String[] args) {
        List<Integer> digits = Arrays.asList(1, 2, 3);

        Common.printIntegerList(digits);
    }


}
