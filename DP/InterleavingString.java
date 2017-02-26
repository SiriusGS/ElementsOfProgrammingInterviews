public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        //f[i][j] 表示s1 前i个字符和s2的前j个字符能否组成s3的前i+j个字符
        
        int s = s1.length();
        int j = s2.length();
        if (s + j != s3.length()) {
            return false;
        }
        boolean[][] f = new boolean[s + 1][j + 1];
        f[0][0] = true;
        for (int i = 1; i <= s; i++) {
            f[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int k = 1; k <= j; k++) {
            f[0][k] = (s2.charAt(k - 1) == s3.charAt(k - 1));
        }
        
        for (int i = 1; i <= s; i++) {
            for (int k = 1; k <= j; k++) {
                f[i][k] = (f[i - 1][k] && s1.charAt(i - 1) == s3.charAt(i + k - 1)) || (f[i][k - 1] && s2.charAt(k - 1) == s3.charAt(k + i - 1));
            }
        }
        
        return f[s][j];
    }
}