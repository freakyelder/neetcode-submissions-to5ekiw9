class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        
        int lon=0;

        for(int num:set){
            if(!set.contains(num-1)){
                int len=1;
                while(set.contains(num+len)){
                    len++;
                }

                lon=Math.max(lon,len);
            }
        }

        return lon;
    }
}
