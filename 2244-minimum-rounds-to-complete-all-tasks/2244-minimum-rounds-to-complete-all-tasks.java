class Solution {
    public int minimumRounds(int[] tasks) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int x : tasks) map.put(x,map.getOrDefault(x,0)+1);
        
        Integer x = map.firstKey();
        // System.out.println(map);
        int count = 0;
        while(x != null){
            
            int total = map.get(x);
            
            if(total== 1) return -1;
            
            
                if(total== 1) return -1;
                if((total % 3) == 0){
                    count += (total/3);
                    total = 0;
                }else
                    count+=total/3 + 1;
            
            
            
            x = map.ceilingKey(x+1);
        }
        return count;
        
        
    }
}
// 2222 33 44444