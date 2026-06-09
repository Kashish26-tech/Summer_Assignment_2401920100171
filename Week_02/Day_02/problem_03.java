//find all anagrams in a string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int left = 0;
        int right = 0;

        List<Integer> result = new ArrayList<>();

        int arr_s[] = new int[26];
        int arr_p[] = new int[26];

        if(k > s.length()) {
            return result;
        }

        for(int i=0; i<k; i++) {
            arr_p[p.charAt(i) - 'a']++;
        }

        for(right=0; right<s.length(); right++) {
            if(right - left + 1 > k) {
                arr_s[s.charAt(left) - 'a']--;
                left++;
            }

            arr_s[s.charAt(right) - 'a']++;

            if(right-left+1 == k) {
                if(Arrays.equals(arr_s, arr_p)) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}
