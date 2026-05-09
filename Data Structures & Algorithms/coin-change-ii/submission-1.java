class Solution {
    public int change(int amount, int[] coins) {

        int[] prev = new int[amount + 1];

        // Base case for first coin
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) prev[i] = 1;
        }

        for (int i = 1; i < coins.length; i++) {

            int[] curr = new int[amount + 1];

            for (int j = 0; j <= amount; j++) {

                int nt = prev[j];

                int tk = 0;
                if (coins[i] <= j)
                    tk = curr[j - coins[i]];

                curr[j] = tk + nt;
            }

            prev = curr;
        }

        return prev[amount];
    }
}