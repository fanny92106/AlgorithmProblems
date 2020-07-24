package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
    // stack1: last end side
    // stack2: first end side
    // buffer: temporarily store half elements when pop()

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    Deque<Integer> buffer;

    public DequeByThreeStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        stack2.offerFirst(element);
    }

    public void offerLast(int element) {
        stack1.offerFirst(element);
    }

    public Integer pollFirst() {
        if(isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            move(stack1, stack2);
        }
        return stack2.pollFirst();
    }

    public Integer pollLast() {
        if(isEmpty()){
            return null;
        }
        if(stack1.isEmpty()){
            move(stack2, stack1);
        }
        return stack1.pollFirst();
    }

    public Integer peekFirst() {
        if(isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            move(stack1, stack2);
        }
        return stack2.peekFirst();
    }

    public Integer peekLast() {
        if(isEmpty()){
            return null;
        }
        if(stack1.isEmpty()){
            move(stack2, stack1);
        }
        return stack1.peekFirst();
    }

    public int size() {
        return stack1.size()+stack2.size();
    }

    public boolean isEmpty() {
        return stack1.size()==0 && stack2.size()==0;
    }

    private void move(Deque<Integer> src, Deque<Integer> dest){
        int size = src.size();
        // move half from src to buffer
        for(int i=0; i<size/2; i++){
            buffer.offerFirst(src.pollFirst());
        }
        // move half from src to dest
        while(!src.isEmpty()){
            dest.offerFirst(src.pollFirst());
        }

        // move all from buffer back to src
        while(!buffer.isEmpty()){
            src.offerFirst(buffer.pollFirst());
        }
    }
}
