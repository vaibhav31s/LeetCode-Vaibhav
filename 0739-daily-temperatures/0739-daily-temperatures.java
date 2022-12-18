class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        
        for(int i = 0; i < temp.length; i++){
            if(stack.isEmpty()){
                stack.push(new Pair(i, temp[i]));
            }else if(stack.peek().getValue() > temp[i]){
                stack.push(new Pair(i, temp[i]));
            }else{
                
                while(!stack.isEmpty() && stack.peek().getValue() < temp[i]){
                    Pair<Integer,Integer> tempp = stack.pop();
                    temp[tempp.getKey()] =i -  tempp.getKey();
                }
                
                stack.push(new Pair(i, temp[i]));
            }
        }
        
        while(!stack.isEmpty()){
                    Pair<Integer,Integer> tempp = stack.pop();
                    temp[tempp.getKey()] =0;
        }
        return temp;
    }
}