import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team,
 like make the rank 1 team play with the rank nth team,
 which is a good strategy to make the contest more interesting.

 Now, you're given n teams, you need to output their final contest matches in the form of a string.

 The n teams are given in the form of positive integers from 1 to n,
 which represents their initial rank.

 (Rank 1 is the strongest team and Rank n is the weakest team.)

 We'll use parentheses('(', ')') and commas(',')
 to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition.

 During the pairing process in each round,
 you always need to follow the strategy of making the rather strong one pair with the rather weak one.

 Example 1:
 Input: 2
 Output: (1,2)

 Explanation:
 Initially, we have the team 1 and the team 2, placed like: 1,2.
 Then we pair the team (1,2) together with '(', ')' and ',', which is the final answer.



 Example 2:
 Input: 4
 Output: ((1,4),(2,3))

 Explanation:
 In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
 And we got (1,4),(2,3).
 In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the paratheses outside them.
 And we got the final answer ((1,4),(2,3)).



 Example 3:
 Input: 8
 Output: (((1,8),(4,5)),((2,7),(3,6)))

 Explanation:
 First round: (1,8),(2,7),(3,6),(4,5)
 Second round: ((1,8),(4,5)),((2,7),(3,6))
 Third round: (((1,8),(4,5)),((2,7),(3,6)))
 Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).
 Note:
 The n is in range [2, 212].
 We ensure that the input n can be converted into the form 2k, where k is a positive integer.

 *
 *
 * Created by Mellon on 3/19/17.
 */
public class OutputContestMatches {
    public static String findContestMatch(int n) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(String.valueOf(i+1));
        }

        for(int m=n;m>1;m=m/2){
            for(int i=0;i<m/2;i++){
                String temp = "(" + res.get(i) + "," + res.get(m-1-i) + ")";
                res.set(i, temp);
            }
        }
        return res.get(0);
    }

    public static void main(String[] args){
        //System.out.println(findContestMatch(16));
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.fromString(uuid1.toString());
        System.out.println(uuid1 == uuid2);
    }

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// (1,16), (2,15), (3,14), (4,13), (5,12), (6,11), (7,10), (8, 9)
// ((1,16), (8,9)), ((2,15), (7,10)), ((3,14), (6,11)), ((4,13),(5,12))
// (((1,16), (8,9)), ((4,13), (5,12))), (((2,15),(7,10)), ((3,14),(6,11)))
// ((((1,16), (8,9)), ((4,13), (5,12))), (((2,15),(7,10)), ((3,14),(6,11))))


}
