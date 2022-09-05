class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int ans = 0;
        int i = 0;
        int[] answer = new int[k];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] arr:  mat){
            int sold =   binarySearch(arr);
            map.putIfAbsent(sold,new ArrayList<>());
            map.get(sold).add(i);
          i++;
        }i= 0;
        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        Collections.sort(key);
        for(int ke : key){    
                              if(k == i) break;

                for(int x :  map.get(ke)){
                    if(k == i) break;
                    answer[i++] = x;
                }
                
        }
       
        
        return answer;
    }
    int binarySearch(int[] arr){
        int start = 0;
        int end = arr.length  - 1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == 1){
                ans = mid;
                start = mid+1;
            }else
            
            if(arr[mid] == 0 ){
                end = mid-1;
            }
        } 
        if(ans == -1) return 0;
        return ans+1;
    }
}
class Pair{
    int val;
    int index;
    Pair( int index, int val){
        this.index = index;
        this.val = val;
    }
}