/**
 * Created by Mellon on 3/25/17.
 */
public class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if(num==0 || num == 1 || num ==2) return false;
        int sum = 1;
        for(int i=2;i*i<num;i++){
            if(num%i==0){
                if(num/i == i)
                    sum = sum + num/i;
                else
                    sum = sum + num/i+ i ;
            }
        }
        return sum == num;
    }

    public static void main(String[] args){

        System.out.print(checkPerfectNumber(8));
    }
}
