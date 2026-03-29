class Solution {
    public int maxProfit(int[] prices) {
        int track_min=prices[0];
        int n=prices.length;
        int mx=0;
        int cp=0;

        for(int i=1;i<n;i++){
            if(prices[i]<track_min)track_min=prices[i];
            cp=prices[i]-track_min;
            mx=Math.max(mx,cp);
        }

        return mx;
    }
}
