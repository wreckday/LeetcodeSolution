/**
 * Created by Mellon on 8/16/15.
 */
public class Pow {
    // time complexity: O(n)
    public static double myPow(double x, int n){
        if(n==0)
            return 1;
        double result = 1;
        int i = 0;
        while(i<n){
            result = result*x;
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        double input = 0.00001;
        System.out.print(pow(input, 2147483647));
    }


    // time complexity: O(log n)
    public static double pow(double x, int n){
		if(n<0)
			return 1.0/power(x, -n);
		else
			return power(x, n);
	}

	private static double power(double x, int n){
		if(n == 0)
			return 1;
		double v = power(x, n/2);
		if(n % 2 == 0)
				return v * v;
		else
			return v * v * x;
	}
}
