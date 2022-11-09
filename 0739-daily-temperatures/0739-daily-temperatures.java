class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] answer = new int[temp.length];
        for(int i =0 ; i < temp.length; i++){
           
                while(!stack.isEmpty() && stack.peek().getKey() < temp[i]){
                    int index = stack.pop().getValue();
                    answer[index] =  i - index;
                }
                stack.push(new Pair(temp[i],i));
            }
        
        // while(!stack.isEmpty()){}
        
        return answer;
    }
}