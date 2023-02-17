package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        first.push(value);

    }
    
    public int deleteHead() {
        if (first.isEmpty() && second.isEmpty()) {
            return -1;
        }

        // pop栈是空的把所有push栈的元素弄过来 只要pop栈还有元素就直接出栈顶层元素就行
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
