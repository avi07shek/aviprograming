public class que3a {
    public int maxPoints(int[] targets) {
        int n = targets.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] paddedTargets = new int[n + 2];

        paddedTargets[0] = paddedTargets[n + 1] = 1;
        System.arraycopy(targets, 0, paddedTargets, 1, n);

   
        for (int i = 1; i <= n; i++) {
            dp[i][i] = paddedTargets[i - 1] * paddedTargets[i] * paddedTargets[i + 1];
        }

        
        for (int len = 2; len <= n; len++) {
            for (int left = 1; left + len - 1 <= n; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][i - 1] + paddedTargets[left - 1] * paddedTargets[i] * paddedTargets[right + 1] + dp[i + 1][right]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        que3a mps = new que3a();
        int[] targets = {3, 1, 5, 8};
        System.out.println(mps.maxPoints(targets)); // Output: 167
    }
}