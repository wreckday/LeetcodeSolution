/**
 * Created by Mellon on 5/20/17.
 */
public class FractionAdditionandSubtraction {
    public static String fractionAddition(String expression) {
        String res = "";
        if(expression.indexOf("/")!=-1) {
            int denominator1 = 0;
            int numerator1 = Integer.parseInt(expression.substring(0, expression.indexOf("/")));
            if(Integer.parseInt(expression.substring(expression.indexOf("/") + 1, expression.indexOf("/") + 2))==1){
                if(expression.substring(expression.indexOf("/") + 2, expression.indexOf("/") + 3)=="0".toString()){
                    denominator1 = Integer.parseInt(expression.substring(expression.indexOf("/") + 1, expression.indexOf("/") + 3));
                }
            }else {
                denominator1 = Integer.parseInt(expression.substring(expression.indexOf("/") + 1, expression.indexOf("/") + 2));
            }

            res = res + numerator1 + "/" + denominator1;
            if(expression.indexOf("/")+2<expression.length()){
                String newString = expression.substring(expression.indexOf("/")+2);
                res = helper(newString, res);
            }
        }
        return res;

    }

    private static String helper(String expression, String res){
        if(expression==null || expression=="") return res;
        if(expression.indexOf("/")!=-1){
            int numerator1 = Integer.parseInt(res.substring(0, res.indexOf("/")));
            int denominator1 = 0;
            if(Integer.parseInt(res.substring(res.indexOf("/") + 1, res.indexOf("/") + 2))==1){
                if(expression.substring(res.indexOf("/") + 2, res.indexOf("/") + 3)=="0".toString()){
                    denominator1 = Integer.parseInt(res.substring(expression.indexOf("/") + 1, res.indexOf("/") + 3));
                }
            }else {
                denominator1 = Integer.parseInt(res.substring(res.indexOf("/") + 1, res.indexOf("/") + 2));
            }

            int numerator2 = Integer.parseInt(expression.substring(0, expression.indexOf("/")));

            int denominator2 = 0;
            if(Integer.parseInt(expression.substring(expression.indexOf("/") + 1, expression.indexOf("/") + 2))==1){
                if(expression.substring(expression.indexOf("/") + 2, expression.indexOf("/") + 3).equals("0".toString())){
                    denominator2 = Integer.parseInt(expression.substring(expression.indexOf("/") + 1, expression.indexOf("/") + 3));
                }
            }else {
                denominator2 = Integer.parseInt(expression.substring(expression.indexOf("/") + 1, expression.indexOf("/") + 2));
            }

            int temp_numerator = (numerator1 * denominator2 + numerator2*denominator1);
            long greatestCommon = gcd(Math.abs(temp_numerator), Math.abs(denominator1 * denominator2));
            if(greatestCommon==0 || temp_numerator==0 || denominator1 * denominator2==0){
                res = "0/1";
            }else {
                long final_numerator = temp_numerator/greatestCommon;
                long final_denominator = denominator1 * denominator2/greatestCommon;
                res = String.valueOf(final_numerator) + "/" + String.valueOf(final_denominator);
            }

            if(expression.indexOf("/")+1<expression.length()){
                String newString = expression.substring(expression.indexOf("/")+2);
                return helper(newString, res);
            }
        }
        return res;
    }

    public static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        String str = "-7/4+7/10-1/3";
        System.out.print(fractionAddition(str));
        //System.out.print("gcd:"+gcd(2, 6));
    }
}
