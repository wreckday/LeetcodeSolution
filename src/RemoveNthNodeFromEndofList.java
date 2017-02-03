/**
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 *
 * Created by Mellon on 8/5/16.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;
        ListNode runner = helper;
        while(n>0){
            runner = runner.next;
            n--;
        }
        while(runner.next!=null){
            runner = runner.next;
            p=p.next;
        }
        p.next = p.next.next;
        return helper.next;
    }
}
