/**
 * Created by Mellon on 3/19/15.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {

        if(num1==null||num1.length()==0||num2==null||num2.length()==0)
            return null;

        int[] num = new int[num1.length()+num2.length()];

        for(int i=0;i<num2.length();i++)
        {
            int a = num2.charAt(num2.length()-i-1)-'0';
            for(int j=0;j<num1.length();j++)
            {
                int b = num1.charAt(num1.length()-j-1)-'0';
                num[i+j] += a*b;
            }
        }

        int carry = 0;
        int copy = 0;
        for(int i=0;i<num.length;i++){
            copy = carry;
            carry = (num[i]+carry)/10;
            num[i] = (num[i]+copy)%10;
        }

        int i = num.length-1;
        // consider "0" * "0", so don't need to check i==0
        while(i>0 && num[i]==0)
        {
            i--;
        }

        StringBuilder res = new StringBuilder();
        while(i>=0)
        {
            res.append(num[i]);
            i--;
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(multiply("425","39"));
    }
}


