import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * Created by Mellon on 7/9/16.
 */
public class CopyListwithRandomPointer {
    // space: O(n); time:O(n)
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        // key is original node, value is copy node
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head,newHead);
        RandomListNode pre = newHead;
        RandomListNode node = head.next;

        // build copy-node list via linking next node
        while(node!=null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node,newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }

        // build random link in copy-node list via Map
        node = head;
        RandomListNode copyNode = newHead;
        while(node!=null) {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
