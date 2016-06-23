/**
 * Created by Mellon on 6/4/16.
 */
public class ExploringNumbers {
    public static int numberOfSteps(int n){
        int count = 0;
        int element = n;
        while(!isPrime(element)){
            count++;
            if(count==n) return -1;
            element = compute(element);
        }
        return count+1;
    }

    public static int compute(int element){
        int sum = 0;
        while(element>0){
            // 57
            int digit = element%10;
            element = element / 10;
            sum = sum+digit*digit;
        }
        return sum;
    }

    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        //System.out.println(numberOfSteps(12366));
        System.out.println(numberOfSteps(999999987));
//        System.out.println(compute(57));
//        System.out.println(isPrime(0));
//        System.out.println(numberOfSteps(57));  // return 4
//        System.out.println(numberOfSteps(1));   // return -1
    }
}
