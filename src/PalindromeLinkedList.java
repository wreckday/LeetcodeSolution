import java.util.List;

/**
 *
 Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?

 *
 * Created by Mellon on 8/1/16.
 */
public class PalindromeLinkedList {

    //先寻找到链表中间节点，然后翻转后半部分链表，再两根指针比较
    public static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null)
            return true;

        //1, 寻找链表中间节点
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)    //注意是fast!=null,而不是fast.next==null, 空指针会抛异常啊！
            slow = slow.next;	//奇数个节点,slow需要往前移动一位.(1,2,3,4,5)

        //2, 翻转后半部分链表
        ListNode p2 = reverseList(slow);

        //3, 前后两根指针比较
        ListNode p1 = head;
        while(p2 != null) { //p2遇到null则结束
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        //是否需要恢复链表的后半部分？

        return true;
    }

    //经典的翻转链表算法
    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(0);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(isPalindrome2(head));
    }
}
