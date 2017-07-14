import java.util.Stack;

/**
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.

 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 *
 * Created by Mellon on 6/22/16.
 */
class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
//        if(stack1.isEmpty()){
//            while(!stack2.isEmpty()){
//                stack1.push(stack2.pop());
//            }
//        }
        stack1.push(x);
    }


    // Removes the element from in front of queue.
    public void pop() {
        peek();
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        int val;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        val = stack2.peek();

        return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stack1.isEmpty()&&stack2.isEmpty())
            return true;
        return false;
    }
}

public class ImplementQueueusingStacks {
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.pop();
        myQueue.peek();
        myQueue.push(4);
    }
}


