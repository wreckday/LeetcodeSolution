import java.util.Arrays;
import java.util.List;

/**
 Given a positive integer n, return the number of all possible attendance records with length n,
 which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

 A student attendance record is a string that only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 Example 1:
 Input: n = 2
 Output: 8
 Explanation:
 There are 8 records with length 2 will be regarded as rewardable:
 "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 Only "AA" won't be regarded as rewardable owing to more than one absent times.
 *
 * Created by Mellon on 4/17/17.
 */
public class StudentAttendanceRecordII {
    private static int count = 0;
    public static int checkRecord(int n) {
        String s = "";
        List<String> record = Arrays.asList("A", "L", "P");

        helper(s, n, record, 1);
        return count;
    }

    private static void helper(String s, int n, List<String> record, int i){
        if(i>n){
            count++;
            return;
        }

        for(String c : record){
            String copyS = s;
            String s2 = s+c;
            if(checkRecord(s2)){
                helper(s2, n, record, i+1);
                s = copyS;
            }
        }
    }

    public static boolean checkRecord(String s) {
        if(s==null || s.length()==0) return false;
        int countA = 0;

        if(s.length()==2){
            if(s.charAt(0)=='A'&& s.charAt(1)=='A') {
                return false;
            }else return true;
        }

        for(int i=0;i<s.length()-2;i++){
            if(s.charAt(i)=='A') countA++;
            else if(s.charAt(i)=='L'&&s.charAt(i+1)=='L'&&s.charAt(i+2)=='L') return false;
        }
        if(s.length()>2&&s.charAt(s.length()-1)=='A') countA++;
        if(s.length()>2&&s.charAt(s.length()-2)=='A') countA++;
        if(countA>1) return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(checkRecord(20));
    }
}
