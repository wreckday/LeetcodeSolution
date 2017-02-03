import java.util.List;

/**
 * Created by Mellon on 8/5/16.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

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

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
                mergeKLists(lists.subList(lists.size()/2, lists.size())));
    }

    /*
    I think my code's complexity is also O(nlogk) and not using heap or priority queue,

    n means the total elements and k means the size of list.

The mergeTwoLists functiony in my code comes from the problem Merge Two Sorted Lists whose complexity obviously is O(n), n is the sum of length of l1 and l2.

To put it simpler, assume the k is 2^x, So the progress of combination is like a full binary tree, from bottom to top. So on every level of tree, the combination complexity is n, beacause every level have all n numbers without repetition. The level of tree is x, ie logk. So the complexity is O(nlogk).

for example, 8 ListNode, and the length of every ListNode is x1, x2,
x3, x4, x5, x6, x7, x8, total is n.

on level 3: x1+x2, x3+x4, x5+x6, x7+x8 sum: n

on level 2: x1+x2+x3+x4, x5+x6+x7+x8 sum: n

on level 1: x1+x2+x3+x4+x5+x6+x7+x8 sum: n

total 3n, nlog8
    * */
}
