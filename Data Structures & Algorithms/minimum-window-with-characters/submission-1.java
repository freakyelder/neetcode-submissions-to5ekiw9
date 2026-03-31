class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty())return "";

        HashMap<Character,Integer> ct=new HashMap<>();
        HashMap<Character,Integer> wt=new HashMap<>();

        for(char c:t.toCharArray()){
            ct.put(c,ct.getOrDefault(c,0)+1);
        }

        int have=0,need=ct.size();
        int reslen=Integer.MAX_VALUE;
        int l=0;
        int[] res={-1,-1};

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);

            wt.put(ch,wt.getOrDefault(ch,0)+1);

            if(ct.containsKey(ch) && wt.get(ch).equals(ct.get(ch)))have++;

            while(have==need){
                if((r-l+1)<reslen){
                    reslen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                char lc=s.charAt(l);
                wt.put(lc,wt.get(lc)-1);

                if(ct.containsKey(lc) && ct.get(lc)>wt.get(lc))have--;

                l++;
            }
        }

        return reslen==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
