class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int l=0;
        int r=n-1;
        int max=0;

        while(l<r){
            int min=Math.min(heights[l],heights[r]);
            max=Math.max(max,(r-l)*min);
            if(heights[l]<heights[r])l++;
            else r--;
        }

        return max;
    }
}
