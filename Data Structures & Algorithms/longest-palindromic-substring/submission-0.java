class Solution {
    public String longestPalindrome(String s) {
        int reslen=0;
        int resInd=0;

        int n=s.length();

        String res="";

        for(int i=0;i<n;i++){
            //for odd 
            int l=i;
            int r=i;

            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>res.length()){
                    res=s.substring(l,r+1);
                }

                l--;
                r++;
            }

            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>res.length()){
                    res=s.substring(l,r+1);
                }

                l--;
                r++;
            }
        }

        return res;
    }
}
