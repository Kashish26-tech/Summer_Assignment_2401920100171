//Evaluate reverse polish notation

class Solution {
    public int evalRPN(String[] tokens) { //O(n)
        Stack<Integer> s = new Stack<>();

        for(String ch : tokens) {
            if(ch.equals("+")) {
                s.push(s.pop() + s.pop());
            }
            else if(ch.equals("-")) {
                int b = s.pop(); //second
                int a = s.pop(); //first
                s.push(a-b);
            }
            else if(ch.equals("*")) {
                s.push(s.pop() * s.pop());
            }
            else if(ch.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a / b);
            }
            else {
                s.push(Integer.parseInt(ch));
            }
        }
        return s.peek();
    }
}
