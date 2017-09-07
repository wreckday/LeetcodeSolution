import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mellon on 8/3/17.
 */
public class Dota2Senate {
    /*
    This is obliviously a greedy algorithm problem.
    Each senate R must ban its next closest senate D who is from another party,
    or else D will ban its next senate from R's party.

    The idea is to use two queues to save the index of each senate from R's and D's parties, respectively.
    During each round, we delete the banned senates' indices; and plus each remaining senate's index with n
    (the length of the input string senate), then move it to the back of its respective queue.

    Time complexity : O(n)
    Space complexity: O(n)
    * */

    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int n = senate.length();

        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R')
                q1.add(i);
            else q2.add(i);
        }

        while(!q1.isEmpty() && !q2.isEmpty()){
            int r_index = q1.poll();
            int d_index = q2.poll();
            if(r_index < d_index)
                q1.add(r_index + n);
            else q2.add(d_index + n);
        }
        return (q1.size() > q2.size())? "Radiant" : "Dire";
    }
 }
