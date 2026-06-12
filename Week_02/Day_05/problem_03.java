//Longest palindromic substring

public class Solution {
    public String longestPalindrome(String s) { //O(n2) , O(1)
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for(int i=0; i<s.length()-1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i+1);

            if(odd.length() > maxStr.length()) {
                maxStr = odd;
            }

            if(even.length() > maxStr.length()) {
                maxStr = even;
            }
        }
        return maxStr;
    }

    private String expandFromCenter(String str, int left, int right) {
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }    
}
