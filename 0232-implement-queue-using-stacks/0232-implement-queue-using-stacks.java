class MyQueue {
    Stack<Integer> first, second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while(first.size() > 1){
            second.push(first.pop());
        }
        int a = first.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        
        return a;
    }
    
    public int peek() {
         while(first.size() > 1){
            second.push(first.pop());
        }
        int a = first.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        
        return a;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */