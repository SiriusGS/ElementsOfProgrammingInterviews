public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
        // write your code here
        
        // if (s == null || s.length() == 0) {
        //     return true;
        // }
        // int n = s.length();
        // boolean[] f = new boolean[n + 1];
        // //默认false；
        // f[0] = true;
        
        // for (int i = 1; i <= n; i++) {
        //     // f[i] = false;
        //     for (int j = 0; j < i; j++) {
        //         if (f[j] == false) {
        //             continue;
        //         }
        //         String sub = s.substring(j, i);
        //         if (dict.contains(sub)) {
        //             f[i] = true;
        //             break;
        //         }
        //     }
            
        // }
        // return f[n];
    }
}