//version 1. 
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()];
        int n = s.length();
        // char itself is a palidrome
        for (int i = 0; i < n; i++) {
            isP[i][i] = true;
        }
        // check if the char and the adjacent char are palindrome
        for (int i = 0; i < n - 1; i++) {
            isP[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        // check if the rest is palindrome;
        for (int i = 2; i < n; i++) {
            for (int start = 0; start + i < n ; start++) {
                isP[start][start + i] = isP[start + 1][start + i - 1] && s.charAt(start) == s.charAt(start + i);
            }
        }
        return isP;
        
    }
    public int minCut(String s) {
        // write your code here
        //state f[i] 表示前i个字符，最少可以切成几个回文串。
        int n = s.length();
        int[] f = new int[n + 1];
        boolean[][] isP = getIsPalindrome(s);
        // 2. initialize
        // f[0] = 0;
        for (int i = 0; i <= n; i++) {
            f[i] = i;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isP[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        
        
        // 3. function
        
        
        
        return f[n] - 1;
        // 4. answer
    }
};



// version 2;
//O(n^2) time, O(n) space
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[]  cut = new int[n+1];  // number of cuts for the first k characters
        char[] c = s.toCharArray(); 
        for (int i = 0; i <= n; i++) cut[i] = i-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >= 0 && i+j < n && c[i-j]==c[i+j] ; j++) // odd length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j]);

            for (int j = 1; i-j+1 >= 0 && i+j < n && c[i-j+1] == c[i+j]; j++) // even length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);
        }
        return cut[n];
    }
}


// version 3;
// O(n^2) time, O(n^2) space
public int minCut(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}