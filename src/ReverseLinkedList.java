/**
 * Created by Mellon on 6/26/16.
 */
public class ReverseLinkedList {
    //recursive
    public ListNode reverseListRecursive(ListNode head){
        ListNode list = head;
        if (list == null) return null;
        if (list.next == null) return list;
        ListNode secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        ListNode reverseRest = reverseList(secondElem);

        // then we join the two lists
        secondElem.next = list;
        return reverseRest;
    }

    public ListNode reverseList(ListNode head) {
         ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = result;
            result = cur;
            cur = temp;
        }
        return result;
    }
}
