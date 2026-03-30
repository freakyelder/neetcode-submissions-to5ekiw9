class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int track_prices=prices[0];
        int cp=0;
        int max=0;

        for(int i=1;i<n;i++){
            track_prices=Math.min(track_prices,prices[i]);
            cp=prices[i]-track_prices;
            max=Math.max(max,cp);
        }

        return max;
    }
}
