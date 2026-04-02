class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] a = new int[26];
        int[] b = new int[26];

        for (char c : s1.toCharArray()) a[c - 'a']++;

        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            b[s2.charAt(i) - 'a']++;

            if (i >= k) {
                b[s2.charAt(i - k) - 'a']--;
            }

            if (match(a, b)) return true;
        }
        return false;
    }

    boolean match(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}