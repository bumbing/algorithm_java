class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> s1 = new Stack(), s2 = new Stack();
    int peek;
    public void push(int x) {
        //o(1)
        if(s1.isEmpty())    peek = x;
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.pop();
        while(!s2.isEmpty()){
            push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {

        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}