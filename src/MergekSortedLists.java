import java.util.List;
import java.util.PriorityQueue;

/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Created by Mellon on 8/6/16.
 */
public class MergekSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        ListNode current = helper;

        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        return helper.next;
    }

    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));

        return mergeTwoLists(
                mergeKLists2(lists.subList(0, lists.size() / 2)),
                mergeKLists2(lists.subList(lists.size() / 2, lists.size()))
        );
    }
//************************************************************************************
/*
For this problem, use merge sort is simple and fast, I wonder why some guys solve it use PriorityQueue.

I think the complexity is k * n * logk. Because the recursion depth is logK, and in each level, every element will be compared.
* */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end){

            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);

            return mergeTwoLists(left, right);

        } else {
            return null;
        }
    }

    /*
    I think my code's complexity is also O(nlogk) and not using heap or priority queue,
    n means the total elements and k means the size of list.

    The mergeTwoLists function in my code comes from the problem Merge Two Sorted Lists whose complexity obviously is O(n),
     n is the sum of length of l1 and l2.

    To put it simpler, assume the k is 2^x, So the progress of combination is like a full binary tree,
     from bottom to top. So on every level of tree, the combination complexity is n,
     because every level have all n numbers without repetition. The level of tree is x, ie logk. So the complexity is O(nlogk).

for example, 8 ListNode, and the length of every ListNode is x1, x2,
x3, x4, x5, x6, x7, x8, total is n.

on level 3: x1+x2, x3+x4, x5+x6, x7+x8 sum: n

on level 2: x1+x2+x3+x4, x5+x6+x7+x8 sum: n

on level 1: x1+x2+x3+x4+x5+x6+x7+x8 sum: n

total 3n, nlog8
    * */


    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        // 1. priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) ->(o1.val-o2.val));
        for(ListNode l : lists){
            pq.add(l);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(pq.size()>0){
            ListNode temp = pq.poll();
            tail.next = temp;
            if(temp.next != null)
                pq.add(temp.next);
        }
        return dummy.next;
    }

}
