import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mellon on 7/22/17.
 */
public class ReplaceWords {
    // 2. Trie
    static class Trie_Node {
        public boolean isWord;
        public Trie_Node[] children = new Trie_Node[26];

        // Initialize your data structure here.
        public Trie_Node() {
        }
    }

    private static Trie_Node root = new Trie_Node();


    // Inserts a word into the trie.
    public static void insert(String word) {
        Trie_Node ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new Trie_Node();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }


    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public static String startsWith(String word) {
        Trie_Node ws = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null)
                return null;
            if(ws.children[c - 'a'].isWord)
                return word.substring(0, i+1);

            ws = ws.children[c - 'a'];
        }
        return null;
    }

    public static String replaceWords(List<String> dict, String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for (String dic : dict) {
            insert(dic);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String str = startsWith(word);
            if (str!=null) {
                res.append(str);
            }else
                res.append(word);

            if (i != words.length - 1)
                res.append(" ");
        }
        return res.toString();
    }



    //***************** Brute force
    public static String replaceWordsSlow(List<String> dict, String sentence) {
        Collections.sort(dict, (s1, s2) -> (s1.toString().length() - s2.toString().length()));
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            boolean replaced = false;
            for(int j=0;j<dict.size();j++){
                if(word.startsWith(dict.get(j))){
                    res.append(dict.get(j));
                    replaced = true;
                    break;
                }
            }
            if(!replaced){
                res.append(word);
            }
            if(i!=words.length-1)
                res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("ca", "cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
        System.out.println(replaceWordsSlow(dict, sentence));
    }

}
