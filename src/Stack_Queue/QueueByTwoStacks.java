package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 Time Complexity:
 offer() - O(1)
 peek() - amortized O(1)
 poll() - amortized O(1)

 Space Complexity:
 O(n)

 Online-algorithm? Yes
 */

public class QueueByTwoStacks {
    // Queue: FIFO
    // stack1: to mimic new elements that pushed into queue
    // stack2: to mimic poll elements from queue
    // if stack2 is not empty, can pop elements from stack2
    // else pop elements from stack1 to stack2, then pop
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public QueueByTwoStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public Integer poll() {
        if(isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            move(stack1, stack2);
        }
        return stack2.pollFirst();
    }

    public void offer(int element) {
        stack1.offerFirst(element);
    }

    public Integer peek() {
        if(isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            move(stack1, stack2);
        }
        return stack2.peekFirst();
    }

    public int size() {
        return stack1.size()+stack2.size();
    }

    public boolean isEmpty() {
        return stack1.size()==0 && stack2.size()==0;
    }

    private void move(Deque<Integer> src, Deque<Integer> dest){
        while(!src.isEmpty()){
            dest.offerFirst(src.pollFirst());
        }
    }
}


