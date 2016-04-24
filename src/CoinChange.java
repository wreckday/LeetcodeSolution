import java.util.Arrays;

/**
 * Created by Mellon on 4/3/16.
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] count = new int[amount+1];
        int MAX = amount + 1;
        Arrays.fill(count, MAX);

        count[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i)
                    count[i] = Math.min(count[i], count[i-coins[j]]+1);
            }
        }
        return count[amount] > amount ? -1 : count[amount];
    }

    public static void main(String[] args){
        int[] coins = {3};
        int amount = 2;
        System.out.print(coinChange(coins, amount));
    }
}
