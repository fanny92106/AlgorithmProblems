package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMinCall {
    // Solution2:
    // stack: hold original elements
    // minStack: hold current min element and it's first occurence
    Deque<Integer> stack;
    Deque<int[]> minStack;

    public StackWithMinCall() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        int res = stack.pollFirst();
        if(stack.size()<minStack.peekFirst()[1]){
            minStack.pollFirst();
        }
        return res;
    }
    public void push(int element) {
        stack.offerFirst(element);
        if(minStack.isEmpty() || element<minStack.peek()[0]){
            minStack.offerFirst(new int[]{element, stack.size()});
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peekFirst();
    }

    public int min() {
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peekFirst()[0];
    }
}
