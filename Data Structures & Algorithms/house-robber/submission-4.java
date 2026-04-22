class Solution {
    public int rob(int[] nums) {
        int n=nums.length;

        if(n==0)return 0;
        if(n==1)return nums[0];

        int p1=nums[0];
        int p2=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int curr=Math.max(p2,nums[i]+p1);
            p1=p2;
            p2=curr;
        }

        return p2;
    }
}
