// sliding window maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //1st window
        for(int i=0; i<k; i++) {
            pq.add(new Pair(nums[i], i));
        }
        result[0] = pq.peek().val;

        for(int i=k; i<nums.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= i - k) {
                pq.remove();
            }
            pq.add(new Pair(nums[i], i));
            result[i - k + 1] = pq.peek().val;
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;
        public Pair(int v, int idx) {
            this.val = v;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }
}
