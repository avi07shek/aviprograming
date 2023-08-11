
import java.util.Arrays;
public class que1b {
    public static int minCoins(int[] ratings) {
        int n = ratings.length;
        int[] coins = new int[n];
        Arrays.fill(coins, 1);
        
       
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                coins[i] = coins[i - 1] + 1;
            }
        }
        
       
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && coins[i] <= coins[i + 1]) {
                coins[i] = coins[i + 1] + 1;
            }
        }
        
        int totalCoins = 0;
        for (int coin : coins) {
            totalCoins += coin;
        }
        return totalCoins;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int result = minCoins(ratings);
        System.out.println("Minimum number of coins required: " + result);
    }
}
