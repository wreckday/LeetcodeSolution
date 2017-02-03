import java.util.ArrayList;
import java.util.List;

/**
 You are playing the following Flip Game with your friend:

 Given a string that contains only these two characters: + and -,
 you and your friend take turns to flip two consecutive "++" into "--".
 The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to compute all possible states of the string after one valid move.

 For example, given s = "++++", after one move, it may become one of the following states:

 [
 "--++",
 "+--+",
 "++--"
 ]

 If there is no valid move, return an empty list [].

 * Created by Mellon on 5/11/16.
 */
public class L293_FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s==null) return res;

        StringBuilder sb;
        for(int i=0;i<s.length()-1;i++){
             sb = new StringBuilder(s);
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+'){
                //s.substring(0, i) + "--" + s.substring(i+2)
                res.add(sb.replace(i, i+2, "--").toString());
            }
        }
        return res;
    }


    public static void main(String[] args){
        String input = "++++";
        List<String> res = generatePossibleNextMoves(input);
        Common.printStringList(res);
        String test = "--++";

        String value = "2.33";
        Integer result = Integer.valueOf(value);
        int v = result;
    }



}
