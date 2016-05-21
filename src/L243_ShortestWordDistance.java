/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


 * Created by Mellon on 5/15/16.
 */
public class L243_ShortestWordDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                index1 = i;
            }

            if(words[i].equals(word2)){
                index2 = i;
            }

            if(index1!=-1 && index2!=-1){
                min = Math.min(min, Math.abs(index1-index2));
            }
        }
        return min;
    }

    public static void main(String[] args){
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        //String word1 = "practice"; String word2 = "coding";
        String word1 = "makes"; String word2 = "coding";
        System.out.println(shortestDistance(words, word1, word2));
    }
}
