

/**
 * Created by Mellon on 9/9/17.
 */
public class ImplementMagicDictionary {
    public static void main(String[] args){
        MagicDictionary obj = new MagicDictionary();
        String[] dict = {"hello", "leetcode"};
        obj.buildDict(dict);
        System.out.print(obj.search("helloo"));
    }

}
class  MagicDictionary{
    String[] dic;
    public MagicDictionary() {
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        this.dic = dict;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(String s : dic){
            if(isSame(s, word)) return true;
        }
        return false;
    }

    private boolean isSame (String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int i = 0;
        int isDifferent = 0;
        while (i<s1.length()) {
            if(s1.charAt(i) != s2.charAt(i)){
                isDifferent ++;
            }
            i++;
        }
        return isDifferent == 1;
    }
}
