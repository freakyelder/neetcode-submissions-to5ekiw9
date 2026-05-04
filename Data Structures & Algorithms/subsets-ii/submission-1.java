class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // step 1: sort
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr)); // add current subset

        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);              // pick
            backtrack(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);  // not pick (backtrack)
        }
    }
}