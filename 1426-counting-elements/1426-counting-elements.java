class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer,Integer> answer = new HashMap<>();
        
        for(int x : arr) answer.put(x, answer.getOrDefault(x, 0)+1);
        
        int count = 0;
        
        boolean[] vis = new boolean[1001];
        for(int x :  arr){

            count += answer.containsKey((x+1)) ? 1 : 0;
            
        }
        
        return count;
        
    }
}