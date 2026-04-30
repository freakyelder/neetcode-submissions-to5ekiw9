class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If sum is odd → cannot partition
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        // Base cases
        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (nums[0] <= target)
            dp[0][nums[0]] = true;

        // Fill DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {

                boolean notPick = dp[i - 1][j];

                boolean pick = false;
                if (nums[i] <= j) {
                    pick = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }
}