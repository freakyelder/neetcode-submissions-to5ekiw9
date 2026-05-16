class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int n = s1.length();

        // first window
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) return true;

        // slide window
        for (int r = n; r < s2.length(); r++) {
            freq2[s2.charAt(r) - 'a']++;       // add new char
            freq2[s2.charAt(r - n) - 'a']--;   // remove old char

            if (Arrays.equals(freq1, freq2)) return true;
        }

        return false;
    }
}