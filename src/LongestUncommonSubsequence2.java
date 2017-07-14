import java.util.*;

/**
 * Created by Mellon on 4/1/17.
 */
public class LongestUncommonSubsequence2 {

    public static int findLUSlength(String[] strs) {
        int max = -1;
//        Map<String, Integer> map = new HashMap<>();
//        for(int i=0;i<strs.length;i++){
//            if(map.containsKey(strs[i])){
//                map.put(strs[i], map.get(strs[i])+1);
//            }else{
//                map.put(strs[i], 1);
//            }
//        }
        for(int i=0;i<strs.length;i++){
            boolean flag = false;
            for(int j=0;j<strs.length;j++){
                if(i==j) continue;
                //if(map.get(strs[i])>1) flag = true;
                // check strs[i] is not subsequence of strs[j]
                // if true, set flag as true
                if(strs[i].length()<=strs[j].length()){
                    if(isSubsequence(strs[j], strs[i])) flag = true;
                }
            }
            if(!flag) max = Math.max(strs[i].length(), max);
        }
        return max;
    }


//********************************************
    public static int findLUSlength2(String[] strs) {
        int max = -1;
        for(int i = 0; i < strs.length; i++) {
            boolean flag = false;
            for(int j = 0; j < strs.length; j++) {
                if(i == j) continue;
                if(isSubs(strs[i], strs[j])) flag = true;
            }
            if(!flag) max = Math.max(strs[i].length(), max);
            flag = false;
        }
        return max;
    }

    private static boolean isSubsequence(String a, String b){
        int i=0;
        int j=0;
        while(i<a.length()&&j<b.length()) {
            if(a.charAt(i)==b.charAt(j)){
                i++; j++;
            }else {
                i++;
            }
        }
        return j==b.length();
    }

    private static boolean isSubs(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() >= s2.length()) return false;
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s1.length();
    }

    public static void main(String[] args){
        String[] input = {"aabbcc", "aabbcc","cb"}; //2
        String[] input2 = {"aaa","aaa","aa"}; //-1
        String[] input3 = {"aabbcc", "aabbcc","bc"};  // -1
        String[] input4 = {"bc", "aabbcc","aabbcc"};  // -1
        String[] input5 = {"ba", "aabbcc","aabbcc"};  // 2

        int res2 = findLUSlength(input);
        //int res2a = findLUSlength2(input5);
        System.out.println(res2);
        //System.out.println(res2a);
    }
}
