class Solution {

    public int rob(int[] nums) {
        int n=nums.length;

        return Math.max(func(nums,0,n-1),func(nums,1,n));
    }

    private int func(int[] nums,int start,int end){
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int prev2=0;
        int prev1=0;

        for(int i=start;i<end;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}
