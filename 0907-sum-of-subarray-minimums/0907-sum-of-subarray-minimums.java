class Solution {
    public int sumSubarrayMins(int[] arr) {
        long answer= 0;
        long mod = 1000000007;
        int[] NSR = new int[arr.length];
        int[] NSL = new int[arr.length];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            while(!stack.isEmpty() && stack.peek().getValue() >= val) stack.pop();
            if(stack.isEmpty()){
                NSL[i] = -1;
            }else{
                NSL[i] = stack.peek().getKey();
            }
                stack.push(new Pair(i, arr[i]));
        }
        stack.clear();
        for(int i = arr.length - 1; i >= 0; i--){
            int val = arr[i];
            while(!stack.isEmpty() && stack.peek().getValue() > val) stack.pop();
            if(stack.isEmpty()){
                NSR[i] = arr.length;
            }else{
                NSR[i] = stack.peek().getKey();
            }
                stack.push(new Pair(i, arr[i]));
        }
        
        
        
        
        for(int i = 0; i < arr.length; i++){
             long left = i - NSL[i];
            long right = NSR[i] - i;
            long total = left * right;
            answer = (answer + ((total) * arr[i])) % mod;
        }
        
   
        
        
        
        
        return (int)(answer% mod);
    }
}


