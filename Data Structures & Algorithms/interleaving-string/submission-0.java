class Solution {
    int n, m, N;
    int[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {

        n = s1.length();
        m = s2.length();
        N = s3.length();

        if (n + m != N) return false;

        dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s1, s2, s3);
    }

    private boolean solve(int i, int j, String s1, String s2, String s3) {

        if (i == n && j == m) return true;

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        int k = i + j;

        boolean result = false;

        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, s1, s2, s3);
        }

        if (!result && j < m && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, s1, s2, s3);
        }

        dp[i][j] = result ? 1 : 0;

        return result;
    }
}