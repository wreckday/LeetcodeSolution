/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 *
 * Created by Mellon on 5/8/16.
 */
public class ImplementTrie {
}

class Trie_Node {
    public boolean isWord;
    public Trie_Node[] children = new Trie_Node[26];
    // Initialize your data structure here.
    public Trie_Node() {}
}

class Trie {
    private Trie_Node root;

    public Trie() {
        root = new Trie_Node();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Trie_Node ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null){
                ws.children[c-'a'] = new Trie_Node();
            }
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        Trie_Node ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null){
                return false;
            }
            ws = ws.children[c-'a'];
        }
        return ws.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        Trie_Node ws = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(ws.children[c-'a']==null)
                return false;
            ws = ws.children[c-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");