/**
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 * Created by Mellon on 7/9/16.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;

        while(runner!=null&&runner.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
