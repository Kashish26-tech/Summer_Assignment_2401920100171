//Squares of a sorted array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int left = 0;
        int right = nums.length-1;

        for(int i=nums.length-1; i>=0; i--) {
            if(Math.abs(nums[right]) > Math.abs(nums[left])) {
                ans[i] = nums[right]*nums[right];
                right--;
            }
            else {
                ans[i] = nums[left]*nums[left];
                left++;
            }
        }
        return ans;
    }
}
