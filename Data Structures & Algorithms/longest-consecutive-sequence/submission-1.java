class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int l = 0;

        for(int num : set){
            int len = 1;
            if(!set.contains(num - 1)){
                while(set.contains(num + len)){
                    len++;
                }
            }
            l = Math.max(l, len);
        }

        return l;
    }
}