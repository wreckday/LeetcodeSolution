import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 8/25/17.
 */
public class PopulatingNextRightPointersinEachNodeII {
    // DFS, 需要存每層最左邊的node, 空間複雜度O(n)
    public void connectDFS(TreeLinkNode root) {
        if (root == null) return;
        List<List<TreeLinkNode>> res = new ArrayList<>();
        helper(root, res, 0);
    }

    private void helper(TreeLinkNode root, List<List<TreeLinkNode>> res, int level) {
        if (root == null) return;
        if (res.size() - 1 < level) {
            List<TreeLinkNode> temp = new ArrayList<>();
            temp.add(root);
            res.add(temp);
        } else {
            res.get(level).get(0).next = root;
            res.get(level).set(0, root);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    // level order traversal, 用一個dummy node 指向當前層的最左邊root的最左邊的小孩, 然後往當前層的右邊一直走(root = root.next), 直到root為null時,
    // 重新把root設為dummy node 的next（換一層繼續走)
    // 時間複雜度O(n), 空間複雜度簡化為O(1)
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        while (root != null) {

            TreeLinkNode currentChild = dummy;
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = dummy.next;
        }
    }
}
