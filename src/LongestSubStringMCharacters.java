import java.util.*;

/**
 * Created by Mellon on 6/1/15.
 */
public class LongestSubStringMCharacters {

    public static void movingWinddow(String s, int m){
        // moving window
        int runner = 0;
        int walker = 0;

        List<List<Integer>> indexes = new ArrayList<List<Integer>>();

        while(runner < s.length()){
            int count = setNum(s, walker, runner,m);
            if(count>m){
                walker++;
            }else if(count<m){
                runner++;
            }else{
                List<Integer> res = new ArrayList<Integer>();
                res.add(walker);
                res.add(runner);
                indexes.add(res);
                runner++;
            }
        }
        // print max length subString
        int max = 0;
        StringBuilder sb = null;
        for(int i=0;i<indexes.size();i++){
            int start = indexes.get(i).get(0);
            int end = indexes.get(i).get(1);
            if(end-start+1 > max){
                max = end-start+1;
                sb = new StringBuilder();
                while(start<=end){
                    sb.append(s.charAt(start));
                    start++;
                }
            }
        }
        System.out.print(sb.toString());
    }

    private static int setNum(String s, int start, int end, int m){
        Set set = new HashSet<Character>();
        while(start<=end)
        {
            set.add(s.charAt(start));
            if(set.size()>m){
                return set.size();
            }
            start++;

        }
        return set.size();
    }

    public static void main(String[] args){
        String s = "abccbcddcabcc";
        movingWinddow(s, 3);
    }
}
