class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)sum+=nums[i];

        int s1=(sum-target)/2;
        if((sum+target)%2!=0||Math.abs(target)>sum)return 0;

        int[] dp=new int[s1+1];
        dp[0]=1;

        for(int num:nums){
            for(int j=s1;j>=num;j--){
                dp[j]+=dp[j-num];
            }
        }

        return dp[s1];
    }
}
