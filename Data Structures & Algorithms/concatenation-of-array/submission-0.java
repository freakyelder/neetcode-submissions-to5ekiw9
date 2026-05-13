class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] res=new int[n*2];
        int c=0;
        for(int i=0;i<n;i++){
            res[c++]=nums[i];
        }
        for(int i=0;i<n;i++){
            res[c++]=nums[i];
        }

        return res;
    }
}