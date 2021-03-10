import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.addFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.addFirst(stack1.removeFirst());
            }
        }

            return stack2.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.addFirst(stack1.removeFirst());
            }
        }

        return stack2.getFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
