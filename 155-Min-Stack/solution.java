public class MinStack {
    Stack<Integer> stack, min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if(this.stack.isEmpty()){
            this.min.push(x);
        }else{
            this.min.push(Math.min(x, min.peek()));
        }
        this.stack.push(x);
    }
    
    public void pop() {
        this.stack.pop();
        this.min.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */