//Daily temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) { //O(n)
        Stack<Integer> s = new Stack<>();
        int answer[] = new int[temperatures.length];
 
        for(int i=0; i<temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int idx = s.pop();
                answer[idx] = i - idx;
            }
            s.push(i);
        }
        return answer;
    }
}
