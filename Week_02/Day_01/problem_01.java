//Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) {
        return false;
       }
       HashMap<Character, Integer> countChar = new HashMap<>();

       for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        countChar.put(ch, countChar.getOrDefault(ch, 0) + 1);
       }

       for(int i=0; i<t.length(); i++) {
        char ch = t.charAt(i);
        if(!countChar.containsKey(ch) || countChar.get(ch) == 0) {
            return false;
        }
        countChar.put(ch, countChar.get(ch) - 1);
       }
       return true;
    }
}
