/**
 You are given a string representing an attendance record for a student.
 The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False
 *
 * Created by Mellon on 4/15/17.
 */
public class StudentAttendanceRecordI {
    public static boolean checkRecord(String s) {
        int countA = 0;

        if(s.length()<3){
            if(s.charAt(0)!='A') return true;
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
        String input = "LALLL";
        System.out.println(checkRecord(input));
    }
}
