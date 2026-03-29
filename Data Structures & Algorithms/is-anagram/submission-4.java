class Solution {
    public boolean isAnagram(String s, String t) {
        int[] f=new int[26];
        if(s.length()!=t.length())return false;

        int n=s.length();

        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);

            f[ch1-'a']++;
            f[ch2-'a']--;
        }

        for(int i=0;i<f.length;i++){
            if(f[i]!=0)return false;
        }

        return true;
    }
}
