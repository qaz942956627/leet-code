package com.lu.stack;

import java.util.Stack;

public class _232_用栈实现队列 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public _232_用栈实现队列() {
        inStack = new Stack();
        outStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        inToOut(inStack, outStack);
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        inToOut(inStack, outStack);
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }

    private void inToOut(Stack<Integer> inStack, Stack<Integer> outStack) {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
