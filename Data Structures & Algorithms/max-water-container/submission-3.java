class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int ar=0;
        int maxar=0;
        while(l<r){
            int min=Math.min(heights[l],heights[r]);
            maxar=Math.max(maxar,(r-l)*min);
            if(heights[l]<heights[r])l++;
            else r--;
        }
        return maxar;
    }
}
