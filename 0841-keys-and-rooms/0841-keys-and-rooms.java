class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        Deque<Integer> dq = new LinkedList<>();
        for(int i :  rooms.get(0)){
            dq.add(i);
        }
        
        while(!dq.isEmpty()){
            int size = dq.size();
            while(size-- > 0){
                int room = dq.poll();
                if(!vis[room]){
                     for(int i :  rooms.get(room)){
                            dq.add(i);
                    }
                }
                vis[room] = true;
                
            }
            
        }
        
        for(boolean x : vis)if(!x)return false;
        
        return true;
        
        
    }
}