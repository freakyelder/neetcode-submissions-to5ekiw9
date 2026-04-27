class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)return 0;

        int l=0;
        int r=height.length-1;
        int lfmx=height[l],rgmx=height[r];
        int res=0;

        while(l<r){
            if(lfmx<rgmx){
                l++;
                lfmx=Math.max(lfmx,height[l]);
                res+=lfmx-height[l];
            }
            else{
                r--;
                rgmx=Math.max(rgmx,height[r]);
                res+=rgmx-height[r];
            }
        }

        return res;
    }
}
