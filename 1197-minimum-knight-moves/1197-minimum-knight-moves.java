class Solution {
    public int minKnightMoves(int x, int y) {
        // Coordinate c=  new Coordinate();
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<Coordinate> dq  = new LinkedList<>();
        dq.add(new Coordinate(0,0));
        
        HashSet<String> set = new HashSet<>();
        set.add("0 0");
        int[] dx  = {2,2,1,1,-1,-1,-2,-2};
        int[] dy  = {-1,1,-2,2,-2,2,-1,1};
        int count = 0;
        
        while(!dq.isEmpty()){
            int n = dq.size();
            while(n-- > 0 ){
                Coordinate l = dq.remove();
                if(l.x == x &&  l.y == y)return count;
                for(int i = 0; i < dx.length; i++){
                    
                    int xx = l.x + dx[i];
                    int yy = l.y + dy[i];
                    String k = xx + " "+ yy;
                    if(set.contains(k)) continue;
                    if(!set.contains(k) &&  xx >= -3 && yy >= -3){
                    dq.add(new Coordinate(xx,yy));
                    set.add(k);
                    }
                }
                
                
            }
        count++;
        }
    return -1;
    }
}

class Coordinate{
    int x;
    int y;
    Coordinate(int x , int y){
        this.x=  x;
        this.y = y;
    }
}