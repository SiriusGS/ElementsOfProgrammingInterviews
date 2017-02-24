public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }
        int s = S.length();
        int t = T.length();
        int[][] f = new int[s + 1][t + 1];
        //f[i][j]表示前S的前i个字符中选取T的前j个字符，有多少种方案。
        for (int i = 0; i <= s; i++) {
            f[i][0] = 1;    
        }
        for (int j = 1; j <= t; j++) {
            f[0][j] = 0;
        }
        
        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= t; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[s][t];
    }
}