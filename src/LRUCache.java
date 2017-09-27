import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Created by Mellon on 7/7/16.
 題目說需要一個cache 可以存資料, 而且這個資料結構是支持get(key), set(key, value), 題目還說這個資料結構如果超過capacity 就要刪除
 最舊的資料。

 1. 因為需要get資料經由 key, 所以可以想到的是hashMap 去存資料。Map<Integer, Node>
 2. 因為需要加入新資料, 刪除最舊的資料, 所以用linkedlist 只需要時間複雜度O(1), 如果用double linkedlist刪除資料時,
    就可以經由要刪除的結點拿到前一個node 的reference 進而刪除要刪除的節點。
 3. 實現的邏輯是, 頭的下一個是最新的節點, 尾巴的前一個是最舊的節點, 頭跟尾巴是dummy nodes, 方便我們寫出簡潔的實現。

 */
public class LRUCache {
    private Map<Integer, DLinkedNode> map;
    private int count;
    private int capacity;
    // head and tail are dummy nodes
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = map.get(key);

        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(int key, int value) {
        DLinkedNode node = map.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.map.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.map.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}
/*
The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
One interesting property about double linked list is that the node can remove itself without other reference.
In addition, it takes constant time to add and remove nodes from the head or tail.

One particularity about the double linked list that I implemented is that
I create a pseudo head and tail to mark the boundary,
so that we don't need to check the NULL node during the update.
 This makes the code more concise and clean, and also it is good for the performance as well.

* */