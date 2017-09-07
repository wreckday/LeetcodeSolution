/**
 Implement int sqrt(int x).

 Compute and return the square root of x.
 *
 * Created by Mellon on 8/16/15.
 */
public class Sqrt {
    // * binaray search
    // remember that the sqrt of an number must less than  its half,
    // than we we can apply binary search to find our target. pleas don't forget the overflow risk
    public static int mySqrt(int x) {
        long start = 0;
        long end = x;

        while(start+1<end){
            long mid = (start+end)/2;
            long value = mid*mid;
            if(value==(long)x){
                return (int)mid;
            }else if(value>(long)x){
                end = mid;
            }else{
                start=mid;
            }
        }

        if(end*end<=x) return (int)end;
        else return (int)start;

    }
    // follow up 求 double
    public static double mySqrtDouble(double x) {
        double start = 0;
        double end = x;

        while(start+1E-6<end){
            double mid = (start+end)/2;
            double value = mid*mid;
            if(value==x){
                return mid;
            }else if(value>x){
                end = mid;
            }else{
                start=mid;
            }
        }

        if(end*end<=x) return end;
        else return start;

    }

    public static void main(String[] args){
        int input = 83;
        //System.out.println(mySqrt(input));
        System.out.print(mySqrtDouble(input));
    }
}
