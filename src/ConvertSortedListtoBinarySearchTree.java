/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * Created by Mellon on 8/29/16.
 */
public class ConvertSortedListtoBinarySearchTree {
    // inorder

    public TreeNode sortedListToBST(ListNode head) {
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
}
