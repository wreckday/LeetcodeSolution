import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mellon on 2/8/15.
 */
public class RepeatedDNA {
    public static List<String> findRepeatedDnaSequences(String s) {
        if(s == null)
            return null;
        List<String> res = new ArrayList<String>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<s.length()-9;i++){
            String cur = s.substring(i,10+i);
            if(map.containsKey(cur)){
                res.add(cur);
            }else{
                map.put(cur, 1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDnaSequences(s);
        for(String t :res){

            System.out.println(t);
        }
    }

}
