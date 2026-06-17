//Min stack

import java.util.Stack;

class MinStack { //O(1)
    Stack<Long> stack;
    long minVal;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push((long)val);
            minVal = val;
        }
        else if(val < minVal) {
            stack.push(2L * val - minVal); //encoded value
            minVal = val;
        }
        else {
            stack.push((long)val);
        }
    }

    public void pop() {
        long top = stack.pop();
        if(top < minVal) {
            minVal = 2L * minVal - top; //restore prev min
        }

    }

    public int top() {
        long top = stack.peek();
        if(top < minVal) {
            return (int)minVal;
        }
        return (int)top;
    }

    public int getMin() {
        return (int)minVal;
    }
}
