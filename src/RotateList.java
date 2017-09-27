import java.util.List;

/**
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 *
 * Created by Mellon on 8/6/16.
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        // fast will become the first list's tail
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        // slow will become the second tail
        // slow.next will be the first list's head
        for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

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
        ListNode result = rotateRight(n1, 3);
        Common.printLinkListNode(result);
    }
}
