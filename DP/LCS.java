public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] lcs = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            lcs[i][0] = 0;
        }    
        
        for (int i = 0; i <= n; i++) {
            lcs[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                    lcs[i][j] = Math.max(lcs[i][j], lcs[i - 1][j - 1] + 1);
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                    lcs[i][j] = Math.max(lcs[i][j], lcs[i - 1][j - 1]);
                }
            }
        }
        return lcs[m][n]; 
    }
}
