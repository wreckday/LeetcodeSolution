import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Write a function to generate the generalized abbreviations of a word.

 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]


 * Created by Mellon on 5/13/16.
 */
public class L320_GeneralizedAbbreviation {
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }

    public static void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if(i == c.length) {
            if(num != 0) sb.append(num);
            res.add(sb.toString());
        } else {
            DFS(res, sb, c, i + 1, num + 1);               // abbr c[i]

            if(num != 0) sb.append(num);                   // not abbr c[i]
            DFS(res, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);
    }
//******************************************************
    public List<String> generateAbbreviations2(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }

    public static void main(String[] args){
        generateAbbreviations("word");
    }
    /*
    For each char c[i], either abbreviate it or not.

    Abbreviate: count accumulate num of abbreviating chars, but don't append it yet.
    Not Abbreviate: append accumulated num as well as current char c[i].
    In the end append remaining num.
    Using StringBuilder can decrease 36.4% time.
    This comes to the pattern I find powerful:

    int len = sb.length(); // decision point
    ... backtracking logic ...
    sb.setLength(len);     // reset to decision point

    * The idea is: for every character,
    * we can keep it or abbreviate it.
    * To keep it, we add it to the current solution and carry on backtracking.
    * To abbreviate it, we omit it in the current solution, but increment the count,
    * which indicates how many characters have we abbreviated.
    * When we reach the end or need to put a character in the current solution,
    * and count is bigger than zero, we add the number into the solution.
    *
    * */
}
