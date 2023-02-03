package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (queue1.isEmpty()) {

            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }
    
    public int pop() {
        if (queue1.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }

    }
    
    public int top() {
        if (queue1.isEmpty()) {
            return peek(queue2, queue1);
        } else {
            return peek(queue1, queue2);
        }
    }

    private Integer peek(Queue<Integer> queue2, Queue<Integer> queue1) {
        int size = queue2.size();
        for (int i = 0; i < size - 1; i++) {
            queue1.offer(queue2.poll());
        }
        Integer poll = queue2.poll();
        queue1.offer(poll);
        return poll;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
