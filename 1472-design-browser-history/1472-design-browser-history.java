class BrowserHistory {
    Stack<String> visit;
    Stack<String> back;
    public BrowserHistory(String homepage) {
        visit = new Stack<>();
        back = new Stack<>();
        visit.push(homepage);
    }
    
    public void visit(String url) {
        back.clear();
        visit.push(url);
    }
    
    public String back(int steps) {
       if(steps >= visit.size()){
            steps = visit.size()-1;
        }
        while(steps >= 1){
            String cur = visit.pop();
            back.push(cur);
            steps--;
        }

        return visit.peek();
    }
    
    public String forward(int steps) {
        if(back.isEmpty()) return visit.peek();
       if(steps >= back.size()){
            steps = back.size();
        }
        while(steps > 0 ){
            String cur = back.pop();
            visit.push(cur); steps--;
        }

        return visit.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */