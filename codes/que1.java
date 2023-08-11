public class que1 {
    public static int minCost(int[][] price) {
        int n = price.length;
        int[][] dp = new int[n][3];
       
        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];
        
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = price[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = price[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = price[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        
       
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
    
    public static void main(String[] args) {
        int[][] price = {{14, 4, 11}, {11, 14, 3}, {14, 2, 10}};
        int result = minCost(price);
        System.out.println("Minimum cost: " + result);
    }
}
