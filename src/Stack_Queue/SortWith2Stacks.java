package Stack_Queue;

import java.util.LinkedList;

/**
 Time Complexity: O(n^2)
 Space Complexity: O(n) -> buffer & result stack
 */

public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // s1: original stack
        // s2: buffer & result stack
        int min = Integer.MAX_VALUE;
        int count = 0;
        while(!s1.isEmpty()){
            // pop elements from s1 to s2, record the min and # of min
            while(!s1.isEmpty()){
                int ele = s1.pollFirst();
                s2.offerFirst(ele);
                if(ele<min){
                    min = ele;
                    count = 1;
                }else if(ele==min){
                    count++;
                }
            }
            // pop elements back from s2 back to s1, except the min elements
            while(!s2.isEmpty() && s2.peekFirst()>=min){
                int ele = s2.pollFirst();
                if(ele>min){
                    s1.offerFirst(ele);
                }
            }
            // push # of min elements into s2
            while(count>0){
                s2.offerFirst(min);
                count--;
            }
            // reset min & count
            min = Integer.MAX_VALUE;
            count = 0;
        }
        // pop all elements from s2 to s1
        while(!s2.isEmpty()){
            s1.offerFirst(s2.pollFirst());
        }
    }
}

