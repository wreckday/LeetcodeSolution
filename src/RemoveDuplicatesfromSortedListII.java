import java.util.List;

/**
 Given a sorted linked list, delete all nodes that have duplicate numbers,
 leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.


 *
 * Created by Mellon on 8/8/16.
 */
public class RemoveDuplicatesfromSortedListII {
    /*
    1->1->2->3->4
 0->1->1->2->3->4

 a  b  c
 a  b     c
 a->c
 b = c;
    *
    *
    * */


    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        ListNode a = dummy;

        ListNode b = head;
        dummy.next = b;
        ListNode c = b.next;
        while(c!=null){
            // keep going to next element until the val is different with b
            while(c!=null && b.val==c.val){
                c = c.next;
            }

            if(b.next==c){
                // move index a b c forward
                a = b;
                b = c;
            }else{
                // remove duplicates nodes
                a.next = c;
                b=c;
            }

            if(c != null)
                c = c.next;

        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = deleteDuplicates(n1);
        Common.printLinkListNode(result);
    }
}

