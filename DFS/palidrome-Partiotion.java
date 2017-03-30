public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> partition = new ArrayList<>();
        helper(s, 0, partition, result);
        return result;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    private void helper(String s, int start, List<String> partition, List<List<String>> result) {
        if (s.length() == start) {
            result.add(new ArrayList<String>(partition));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            partition.add(subString);
            helper(s, i + 1, partition, result);
            partition.remove(partition.size() - 1);
        }
    }
}