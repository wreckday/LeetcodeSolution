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
    public static RandomListNode copyRandomListHashMap(RandomListNode head) {
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

    /*
    ＃＃＃思路：第一種解法是用hashMap 一邊儲存 舊的節點和新的節點連結, 一邊構造新的list, key 就是舊的節點,  value 就是新的節點,
    有了這個連結, 再一邊iterate 舊的linkedlist 一邊連結新的list 的random pointer.
    這個時間複雜度是O(n), 空間複雜度O(n)因為需要一個map.
    第二種解法不需要用到額外空間, 可以拆解為三個小部分,  首先, 先copy next 節點 構造成
    1->1'->2->2'->3->3'->null, 第二步再copy random pointer, 最後, split to two lists.
    其實linkedlist 的問題可以在基本操作上下功夫, 都不會很難 , 重點是怎麼把複雜的問題拆成各種的基本操作小問題。
    */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        // 1->1'->2->2'->3->3'->null
        RandomListNode cur = head;
        while(cur!= null) {
            RandomListNode copyNode = new RandomListNode(cur.label);
            RandomListNode nextNode = cur.next;
            cur.next = copyNode;
            copyNode.next = nextNode;
            cur = nextNode;
        }
        // copy random pointer
        cur = head;
        while(cur != null){
            if(cur.random!=null && cur.random.next!= null){
                cur.next.random = cur.random.next;

            }
            cur = cur.next.next;
        }
        // split two lists      //1->1'->2->2'->3->3'->null
        RandomListNode newHead = head.next;
        RandomListNode copy = newHead;
        while(head!=null){
            copy = head.next;
            head.next = copy.next;
            head = head.next;
            if(head != null){
                copy.next = head.next;
                copy = head.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        node1.random = node1;
        node2.random = node4;

        RandomListNode res = copyRandomList(node1);
        printRandomListNode(res);

    }

    public static void printRandomListNode(RandomListNode listNode){
        while(listNode!=null){
            System.out.print(listNode.label);
            if(listNode.next!=null)
                System.out.print("->");
            listNode = listNode.next;
        }
    }
}




class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
