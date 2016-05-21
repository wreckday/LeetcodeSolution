import java.util.*;

/**
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words
 * and your method will be called repeatedly many times with different parameters. How would you optimize it?

 Design a class which receives a list of words in the constructor,
 and implements a method that takes two words word1 and word2
 and return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * Created by Mellon on 5/15/16.
 */
public class L244_ShortestWordDistanceII {
    /*
    In shortest( ) function, since list1 (size n) and list2 (size m) are sorted already,
    we can use the idea of merge sort and perform the comparison in O(n + m) time, rather than O(n * m).
    */

    HashMap<String,LinkedList<Integer>> map;

    public L244_ShortestWordDistanceII(String[] words) {
        map = new HashMap<String, LinkedList<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String curWord = words[i];
            if(!map.containsKey(curWord)) map.put(curWord,new LinkedList<Integer>());
            map.get(curWord).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int shortest = Integer.MAX_VALUE;
        LinkedList<Integer> word1List = map.get(word1);
        LinkedList<Integer> word2List = map.get(word2);
        int w1Index = 0;
        int w2Index = 0;

        while(w1Index < word1List.size() && w2Index < word2List.size()) {
            int w1 = word1List.get(w1Index);
            int w2 = word2List.get(w2Index);
            shortest = Math.min(shortest, Math.abs(w1-w2));
            if(w1<w2)
                w1Index++;
            else
                w2Index++;
        }
        return shortest;
    }
}
