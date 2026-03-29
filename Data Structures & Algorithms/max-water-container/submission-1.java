class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;

        int mx=0;

        while(l<r){
            int ht=Math.min(heights[l],heights[r]);
            mx=Math.max(mx,(r-l)*ht);

            if(heights[l]<heights[r])l++;
            else r--;
        }

        return mx;
    }
}
