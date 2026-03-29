class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++)set.add(nums[i]);

        int l=0;

        for(int i=0;i<n;i++){
            int len=0;
            if(!set.contains(nums[i]-1)){
                while(set.contains(nums[i]+len))len++;
            }

            l=Math.max(l,len);
        }

        return l;
    }
}
