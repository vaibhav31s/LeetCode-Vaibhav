class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
          
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;});
        
        Stack<int[]> stack = new Stack<>();
        for(int i =points.length - 1; i >=0 ; i--){
            stack.push(points[i]);
        
        }
        
        int count  = 0;
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int a = top[0];
            int b= top[1];
            while(!stack.isEmpty() && stack.peek()[0] <= b){
                stack.pop();
            }
            count++;
        }
            return count;
    }
}

