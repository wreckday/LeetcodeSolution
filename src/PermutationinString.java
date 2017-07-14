import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 4/29/17.
 */
public class PermutationinString {

    public static boolean checkInclusionSlow(String s1, String s2) {
        List<String> permute = permute(s1);
        for(String s : permute){
            if(s2.indexOf(s)>=0){
                return true;
            }
        }
        return false;
    }

    public static List<String> permute(String s1) {
        List<String> permutation = new ArrayList<>();
        helper("", permutation, s1, new boolean[s1.length()]);
        return permutation;
    }

    private static void helper(String str, List<String> res, String s1, boolean[] visited){
        // base case
        if(str.length()==s1.length()){
            res.add(str);
            return;
        }

        for(int i=0;i<s1.length();i++){
            if(!visited[i]) {
                visited[i] = true;
                str = str + s1.charAt(i);
                helper(str, res, s1, visited);
                StringBuilder sb = new StringBuilder(str);
                str = (sb.delete(sb.length()-1, sb.length())).toString();
                visited[i] = false;
            }
        }
    }


    public static boolean checkInclusion(String s1, String s2) {
        List<Character> listA = new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            listA.add(s1.charAt(i));
        }
        List<Character> copy = new ArrayList<>(listA);
        for(int i=0;i<s2.length();i++){
            if(copy.contains(s2.charAt(i))){
                copy.remove((Character)s2.charAt(i));
                if(copy.isEmpty()) return true;
            }else{
                copy = new ArrayList<>(listA);
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s1 = "ba";
        //Common.printStringList(permute(s1));
        String s2 = "eidbaooo";
        System.out.print(checkInclusion(s1, s2));
    }
}
