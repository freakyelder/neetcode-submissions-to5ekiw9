class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        
        // find max pile
        for (int p : piles) {
            r = Math.max(r, p);
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid;
                r = mid - 1; // try smaller speed
            } else {
                l = mid + 1; // need more speed
            }
        }

        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;

        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil(p/k)
        }

        return hours <= h;
    }
}