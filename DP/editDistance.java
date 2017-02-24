public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int w1 = word1.length();
        int w2 = word2.length();
        int[][] f = new int[w1 + 1][w2 + 1];
        // f[i][j] is the min steps for  i prefix in word1 to change to j prefix in word2;
        for (int i = 0; i <= w1; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= w2; i++) {
            f[0][i] = i;
        }
        
        for (int i = 1; i <= w1; i++) {
            for (int j = 1; j <= w2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                    // f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                } else {
                    f[i][j] = Math.min(f[i -1][j - 1] + 1, f[i][j - 1] + 1);
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                }
            }
        }
        return f[w1][w2];
    }
}