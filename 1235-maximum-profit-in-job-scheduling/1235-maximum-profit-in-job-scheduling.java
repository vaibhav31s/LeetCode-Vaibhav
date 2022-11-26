class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
        TreeMap<Integer, List<job>> map = new TreeMap<>();
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
       List<job> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new job(startTime[i], endTime[i], profit[i]));
        }
        
        Collections.sort(jobs, (a, b) -> a.end - b.end);
        
        
        
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
     
        tmap.put(0, 0);
        int ans = 0;
        for (job curr : jobs) {
            int lastEntryTillStart = tmap.floorKey(curr.start);
            int maxProfitTillStart = tmap.get(lastEntryTillStart);
            ans = Math.max(ans, maxProfitTillStart + curr.profit);
            tmap.put(curr.end, ans);
        }

        return ans;
    }
    
    
    Integer dfs(Integer start){
        
        if(start == null) return 0;
        // if(dp.containsKey(start)) return dp.get(start);
        int max = 0;
        int maxP= 0;
        
        for(job b :  map.get(start)){
            
         
                int pp = b.profit;
                b.profit = 0;
          
                int bb = Math.max(dfs(map.ceilingKey(b.end + 1)), dfs(map.ceilingKey(b.end)));
                max = Math.max(max, bb);
                maxP = Math.max(maxP, pp);
                b.profit = pp;
             
            
        }
            
        // dp.put(start, max + maxP);
        return max + maxP;
    }
}
class job{
    int start;
    int end;
    int profit;
    boolean vis = false;
    job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
    
    
}