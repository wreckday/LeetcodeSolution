/**
 * Created by Mellon on 9/13/15.
 */
public class PaintFence {
    public static int numWays(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }

    public static void main(String[] args){
        int n = 2;
        int k = 2;
        System.out.println(numWays(n,k));
    }
}
