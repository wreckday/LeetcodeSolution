import java.util.*;

/**
 * You are playing the following Flip Game with your friend:
 *
 Given a string that contains only these two characters:
 + and -, you and your friend take turns to flip two consecutive "++" into "--".
 The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 For example, given s = "++++", return true.
 The starting player can guarantee a win by flipping the middle "++" to become "+--+".

 Follow up:
 Derive your algorithm's runtime complexity.

 * Created by Mellon on 5/11/16.
 */
public class L294_FlipGameII {

    public static boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);

                if (!canWin(t)) {
                    System.out.println(t);
                    return true;
                }
            }
        }
        return false;
    }

    //If we use HashMap to memorize both win string & lose string, we can further reduce time from 208ms to 18ms:
    public boolean canWinHashMap(String s) {
        if(s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return canWinHashMap(s, map);
    }

    public boolean canWinHashMap(String s, Map<String, Boolean> map){
        // base case
        if(map.containsKey(s))
            return map.get(s);

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWinHashMap(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    // 博弈理論
    public static boolean canWin2(String s) {
        s = s.replace('-', ' ');
        int G = 0;
        List<Integer> g = new ArrayList<>();
        for (String t : s.split("[ ]+")) {
            int p = t.length();
            if (p == 0) continue;
            while (g.size() <= p) {
                char[] x = t.toCharArray();
                int i = 0, j = g.size() - 2;
                while (i <= j)
                    x[g.get(i++) ^ g.get(j--)] = '-';
                g.add(new String(x).indexOf('+'));
            }
            G ^= g.get(p);
        }
        return G != 0;
    }

    public static void main(String[] args){
        String input = "++--+--++++-+";
        System.out.print(canWin2(input));
    }
}
