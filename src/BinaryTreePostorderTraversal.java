import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mellon on 3/22/15.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root==null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        // point : need to record "pre TreeNode"
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else
            {
                //思路可以参考其他两种，区别是最下面在弹栈的时候需要分情况一下：

                TreeNode peekNode = stack.peek();
                //1）如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），
                //那么就把当前结点移到右结点继续循环；
                if(peekNode.right!=null && pre != peekNode.right)
                {
                    root = peekNode.right;
                }
                else
                {  //2）如果栈顶元素右结点是空或者已经访问过，
                    //那么说明栈顶元素的左右子树都访问完毕，应该访问自己继续回溯了。
                    stack.pop();
                    res.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        return res;
    }
}
