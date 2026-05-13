class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        // bucket[i] stores numbers that appear i times
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Step 3: Traverse buckets from high frequency to low frequency
        int[] res = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq >= 0; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    res[index++] = num;

                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}