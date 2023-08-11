import java.util.Arrays;
public class que2a {

    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        
        Arrays.fill(dp, 1);

        
        for (int i = 1; i < n; i++) {
            
            for (int j = i - 1; j >= 0 && i - j <= k; j--) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        
        int longestLength = 0;
        for (int len : dp) {
            longestLength = Math.max(longestLength, len);
        }

        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 3;
        int output = longestSubsequence(nums, k);
        System.out.println("Length of the longest subsequence: " + output);
    }
}

