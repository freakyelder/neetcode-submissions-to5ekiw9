class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        int comp=0;

        for(int i=0;i<n;i++){
            comp=target-nums[i];
            if(map.containsKey(comp))return new int[]{map.get(comp),i};
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}
