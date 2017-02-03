/**
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * Created by Mellon on 8/6/16.
 */
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while(pre!=null && pre.next!=null && pre.next.next!=null){
            ListNode a = pre.next;
            ListNode b = a.next;
            ListNode c = b.next;

            pre.next = b;
            b.next = a;
            a.next = c;
            pre = a;
        }
        return dummy.next;

    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = swapPairs(n1);
        Common.printLinkListNode(result);
    }

}
