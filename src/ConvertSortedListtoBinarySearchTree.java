/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * Created by Mellon on 8/29/16.
 */
public class ConvertSortedListtoBinarySearchTree {
    /*
    ＃＃＃思路： 這一題跟Convert Sorted Array to Binary Search Tree 不同的地方是因為這一題我們不可以直接拿到linkedlist node借由index.
    而且題目說元素是從小到大排序過的, 所以最好的辦法是用按照listNode的排序建構樹, 所以代碼用inorder traverse 去實現建構這棵樹,
    要注意的點是, 要有一個reference 指向現在輪到的listNode, time:O(n); 也可以用postOrder 的方法去建構樹, 不過要在每次遞迴中
    找出sublist 的中點, 時間是O(NlogN), 代碼裡的end 是exclusive

    ＃＃＃時間複雜度：
    ＃＃＃空間複雜度：
    ＃＃＃相關題：
    ＃＃＃哪些條件提示我想到了解法：
    */


    public TreeNode sortedListToBSTNlogN(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {

        ListNode slow = head;
        ListNode fast = head;

        if (head == tail)
            return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow is root now
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);

        return thead;
    }
    // **********************************    inorder solution time complexity: O(n)
    private static ListNode node;

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    public static TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        root.right = right;

        return root;
    }

    public static void main(String[] args){
        // 1->2->3->4->5
        int[] input = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for(int i=1;i<input.length;i++){
            ListNode current = new ListNode(input[i]);
            listNode.next = current;
            listNode = listNode.next;
        }
        TreeNode res = sortedListToBST(head);
        int v = 9;

    }
}
