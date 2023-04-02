class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long target) {
        int p = 0;
        // Arrays.sort(spells);
        Arrays.sort(potions);
        int[] success = new int[spells.length];
        for(int x : spells){
            
            
            success[p++] = potions.length -  go(x, potions, target);
            
            
        }
        System.out.println(Arrays.toString(success));
        
        return success;
        
    }
    
    
    int go(int mul ,int[] arr, long target){
        int start  = 0;
        int end = arr.length-1;
        int answer = arr.length ;
        while(start <= end){
            int mid = start + (end-start)/2;
            long cur = (long)(arr[mid]) * mul;
            if(cur >= target){
                answer = mid;
                end = mid - 1;
            }else start = mid +1;
        }
        
        
        return answer;
    }
    
}