package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackByQueues {
    // q1: hold new elements for push() operation
    // q2: temporarily store moved elements for pop() and peek() operation
    Deque<Integer> q1;
    Deque<Integer> q2;
    /** Initialize your data structure here. */
    public StackByQueues() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offerFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if(isEmpty()){
            return null;
        }
        while(q1.size()>1){
            q2.offerFirst(q1.pollLast());
        }
        int ele = q1.pollLast();
        Deque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ele;
    }

    /** Get the top element. */
    public Integer top() {
        if(isEmpty()){
            return null;
        }
        while(q1.size()>1){
            q2.offerFirst(q1.pollLast());
        }
        int ele = q1.peekLast();
        q2.offerFirst(q1.pollLast());
        Deque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ele;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return q1.size()==0;
    }

}
