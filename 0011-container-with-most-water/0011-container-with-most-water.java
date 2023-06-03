class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int start = 0;
        int end = height.length-1;
        while(start <= end){
            int len = end - start;
            answer = Math.max(len * Math.min(height[start],height[end]), answer);
            if(height[start] < height [end]){
                start++;
            }else end--;
        }
        
        
        
        return answer;
    }
}