class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return function(nums,0,-1);
    }

    private int function(int[] nums,int ind,int prev){
        if(ind==nums.length)return 0;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];

        int not_pick=function(nums,ind+1,prev);

        int pick=0;

        if(prev==-1 || nums[ind]>nums[prev]){
            pick=1+function(nums,ind+1,ind);
        }

        return dp[ind][prev+1]=Math.max(pick,not_pick);
    }
}
