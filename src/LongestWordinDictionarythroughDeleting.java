import java.util.Arrays;
import java.util.List;

/**
 * Created by Mellon on 2/25/17.
 */
public class LongestWordinDictionarythroughDeleting {
    private static String longestWord="";
    public static String findLongestWord(String s, List<String> d) {
        if(s==null || s.length()==0 ||d.size()==0) return longestWord;
        StringBuilder sb = new StringBuilder(s);
        helper(sb, d);
        return longestWord;
    }
    private static void helper(StringBuilder sb, List<String> d){
        if(sb.length()==0) return;
        if(d.contains(sb.toString())){
            if(sb.length()>longestWord.length()){
                longestWord = new String(sb);
            } else if(sb.length()==longestWord.length()){
                if(sb.toString().compareTo(longestWord)<0)
                    longestWord = new String(sb);
            }
        }
        String copy = new String(sb);
        for(int i=0;i<sb.length();i++){
            helper(sb.deleteCharAt(i), d);
            sb = new StringBuilder(copy);
        }
    }


    public static String findLongestWord2(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            String tmp = s;
            boolean isValid = true;
            for (char c : word.toCharArray()) {
                if (tmp.indexOf(c) != -1) {
                    tmp = tmp.substring(tmp.indexOf(c) + 1);
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (word.length() > result.length()) {
                    result = word;
                } else if (word.length() == result.length()) {
                    result = result.compareTo(word) < 0 ? result : word;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> d = Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
        String s2 = "abpcpleayre";
        List<String> d2 = Arrays.asList("ale","bppa","monkey","plea");
        System.out.println(findLongestWord(s2, d2));
    }
}
