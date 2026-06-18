//Largest Rectangle in histogram

class Solution {
    public int largestRectangleArea(int[] arr) { //O(n)
        int maxArea = 0;
        int nsr[] = new int[arr.length];        
        int nsl[] = new int[arr.length];  

        //next smallest right --> index is storing 
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length; //-1
            }
            else {
                nsr[i] = s.peek();
            }
            s.push(i); 
        }      

        //next smaller left
        s = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = s.peek();
            }
            s.push(i); 
        }

        //Current area
        for(int i=0; i<arr.length; i++) {
            int height =arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }
}
