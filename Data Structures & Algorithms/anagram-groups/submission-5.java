class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();

        for(String s:strs){
            int[] f=new int[26];

            for(char c:s.toCharArray()){
                f[c-'a']++;
            }

            String k=Arrays.toString(f);

            if(!map.containsKey(k))map.put(k,new ArrayList<>());

            map.get(k).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
