//Maximum subarray
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            count  += nums[i];
            max = Math.max(count, max);
            if(count < 0){
                count = 0;
            }
        }
        return max;
    }
}
