/**
 * ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * Created by Mellon on 4/27/15.
 */
public class ZigZagConversion {
    //O(n)
    public static String convert(String s, int numRows) {
        //We should be careful about the situation when nRows = 1.
        // Because our formula is not suitable when nRows = 1.
        // And the inner loop should start from i, not 0.
        int step= 2 *numRows -2;

        if(numRows==1) return s;

        StringBuilder sb = new StringBuilder();


        for(int i=0;i<numRows;i++){

            if(i==0 || i==numRows-1)
            {
                for(int j=i;j<s.length();j=j+step){
                    sb.append(s.charAt(j));
                }
            }
            else
            {
                int j=i;
                // if there are 4 rows
                // imaging that the second line is only having three rows
                // and the second line can be seen as the first row for the three lines
                int step1 = 2*(numRows-j)-2;
                int step2 = step-step1;
                boolean flag = true;

                while(j<s.length()){
                    sb.append(s.charAt(j));
                    if(flag){
                        j = j + step1;
                    }else{
                        j= j + step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){

        System.out.println(convert("AB", 1));
    }
}
