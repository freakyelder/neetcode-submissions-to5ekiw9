class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suff=new int[n];
        prefix[0]=1;
        suff[n-1]=1;
        int[] res=new int[n];

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=nums[i+1]*suff[i+1];
        }
        for(int i=0;i<n;i++)res[i]=prefix[i]*suff[i];

        return res;
    }
}  
