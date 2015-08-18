/**
 * Created by Mellon on 8/16/15.
 */
public class Sqrt {
    public static int mySqrt(int x) {
        int l = 0;
        int h = x;

        while(l<=h){
            int m = (l+h)/2;
            int value = m*m;
            if(value==x){
                return m;
            }else if(value>x){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return h;

    }

    public static void main(String[] args){
        int input = 83;
        System.out.print(mySqrt(input));
    }
}
