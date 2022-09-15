class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        if(changed.length % 2 == 1) return new int[]{}; 
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int[] answer = new int[changed.length/2];
        int i = 0;
        for(int x : changed)
            map.put(x, map.getOrDefault(x,0)+1);
        for(int x : changed){
            if(map.getOrDefault(x,0) > 0){
                map.put(x, map.getOrDefault(x, 0)-1);
                if(map.getOrDefault(x*2,0)  >  0){
                    map.put(x*2, map.getOrDefault(x*2, 0)-1);
                    answer[i++] = x;
                }
                // if(i > (changed.length/2)+1) return answer;
            }
              
        }
        if(i < answer.length) return new int[]{};
        return answer;
    }
}

      
    

