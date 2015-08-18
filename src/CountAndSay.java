/**
 * Created by Mellon on 6/4/15.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        if(n==0)
            return "";

        String s = "1";
        int num = 1;
        // here n-1 is because we started from s = 1
        for(int i=0;i<n-1;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<s.length();j++){
                // should check before the latest element
                if(j < s.length()-1 && s.charAt(j) == s.charAt(j+1)){
                    num++;
                }else{
                    sb.append(num+""+s.charAt(j));
                    num = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args){
        System.out.print(countAndSay(12));
    }
}
