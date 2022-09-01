class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int[] answer = {-1,-1};
        int end = numbers.length - 1;
        while(start < end){
            if(numbers[start] +  numbers[end] == target){
                answer[0] = start+1;
                answer[1] = end+1;
                break;
            } 
            if(numbers[start] +  numbers[end] > target){
                end--;
            }else start++;
        }
            
        return answer;
    }
}