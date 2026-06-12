//Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { //O(n*k)
        Map<String, List<String>> result = new HashMap<>();

        for(String s : strs) {
            int count[] = new int[26]; 

            for(char ch : s.toCharArray()) { //O(k)
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int n : count) {
                sb.append(n).append(",");
            }

            String key = sb.toString();
            if(!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
