/**
 * Created by Mellon on 9/19/17.
 */
public class StringtoInteger {
    public static int atoi(String str) {
        if(str == null || str.length()==0) return 0;
        // trim str
        str = str.trim();
        boolean isNegative = false;
        if(str.charAt(0)=='+'){
            str = str.substring(1);
        }else if(str.charAt(0)=='-'){
            isNegative = true;
            str = str.substring(1);
        }

        // 小數點

        float res = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.') break;
            if(str.charAt(i)-'0'<0 || str.charAt(i)-'0'>9) break;
            res = res * 10 + str.charAt(i)-'0';
        }

        if(isNegative){
            res = -1*res;
        }

        if(res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if(res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)res;

    }

    public static void main(String[] args){
        String s = "1234567890123456789012345678901234567890";
        //System.out.println(atoi(s));

        System.out.println(Float.MAX_VALUE);
    }
}
