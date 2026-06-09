//permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> c1 = new HashMap<>();
        HashMap<Character, Integer> c2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            c1.put(s1.charAt(i), c1.getOrDefault(s1.charAt(i), 0)+1);
            c2.put(s2.charAt(i), c2.getOrDefault(s2.charAt(i), 0)+1);
        }

        if(c1.equals(c2)) return true;

        int left = 0;
        for(int right=s1.length(); right<s2.length(); right++) {
            c2.put(s2.charAt(right), c2.getOrDefault(s2.charAt(right), 0)+1);

            c2.put(s2.charAt(left), c2.get(s2.charAt(left))-1);
            if(c2.get(s2.charAt(left)) == 0) {
                c2.remove(s2.charAt(left));
            }
            left++;

            if(c1.equals(c2)) {
                return true;
            }
        }
        return false;
    }
}
