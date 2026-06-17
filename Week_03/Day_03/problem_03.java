//next greater element 1

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { //O(n + m)
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek() < nums2[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                hm.put(nums2[i], -1);
            }
            else {
                hm.put(nums2[i], s.peek());
            }

            s.push(nums2[i]);
        }

        int nextGreater[] = new int[nums1.length];

        for(int i=0; i<nums1.length; i++) {
            nextGreater[i] = hm.get(nums1[i]);
        }

        return nextGreater;
    }
}
