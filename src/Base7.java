/**
 * Created by Mellon on 2/11/17.
 */
public class Base7 {
    public static String convertTo7(int num) {
        if(num ==0) return "0";
        boolean isNegative = false;
        if(num<0){
            isNegative = true;
            num = -1*num;
        }
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0, num%7);
            num=num / 7;
        }
        return isNegative?sb.insert(0, "-").toString():sb.toString();
    }

    public static void main(String[] args){
        System.out.println(convertTo7(5));
    }
}
