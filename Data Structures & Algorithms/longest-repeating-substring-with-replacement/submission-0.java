class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int maxf=0;
        int res=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            maxf=Math.max(maxf,map.get(ch));

            while((i-l+1)-maxf>k){
                char left=s.charAt(l);
                map.put(left,map.get(left)-1);
                l++;
            }

            res=Math.max(res,(i-l+1));
        }

        return res;
    }
}
