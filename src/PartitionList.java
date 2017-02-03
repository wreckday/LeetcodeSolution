import java.util.LinkedList;

/**
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 *
 * Created by Mellon on 8/28/16.
 */
public class PartitionList {
//    # separate the list into 2 distinct lists and link them afterwards.
//            # p1, p2 traverses the list and hd1 and hd2 are the heads of two lists
    public static ListNode partition(ListNode head, int x) {

        ListNode smallerHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);

        ListNode smaller = smallerHead;
        ListNode bigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        // no need for extra check because of fake heads
        smaller.next = biggerHead.next; // join bigger after smaller
        bigger.next = null; // cut off anything after bigger
        return smallerHead.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode resHead = partition(n1, 3);
        Common.printLinkListNode(resHead);

    }
}
