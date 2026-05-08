class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;

        // Add all rotten oranges to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) return 0;

        int time = 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] node = q.poll();

                int row = node[0];
                int col = node[1];

                for (int[] d : dir) {

                    int r = row + d[0];
                    int c = col + d[1];

                    if (r < 0 || c < 0 || r >= m || c >= n)
                        continue;

                    if (grid[r][c] == 1) {

                        grid[r][c] = 2;
                        fresh--;

                        q.offer(new int[]{r, c});

                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute)
                time++;
        }

        return fresh == 0 ? time : -1;
    }
}