class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2002];
        for(int x: arr)
            map[x+1000]++;
        
        boolean[] set = new boolean[1001];
        for(int val: map){
          if(val == 0) continue;
          if(set[val]) return false;
          set[val] = true;
        }
        return true;
    }
}