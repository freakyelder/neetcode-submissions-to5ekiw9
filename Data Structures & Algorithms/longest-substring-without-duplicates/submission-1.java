class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int n=s.length();
        int l=0;
        int r=0;
        int mx=0;

        for(int i=0;i<n;i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(i));
            mx=Math.max(mx,i-l+1);
        }

        return mx;
    }
}
