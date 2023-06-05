class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        Collections.sort(arrays, (a,b)->{
            return a.get(0) - b.get(0);
        });
        int min = arrays.get(0).get(0);
        int max= Integer.MIN_VALUE;
        for(int i = 1; i < arrays.size(); i++){
            max= Math.max(Math.abs(min- arrays.get(i).get(arrays.get(i).size()-1)), max);
             max= Math.max(Math.abs(min- arrays.get(i).get(0)), max);
           
        }
        
        Collections.sort(arrays, (a,b)->{
            return a.get(a.size()-1) - b.get(b.size()-1);
        });
        
        min = arrays.get(arrays.size()-1).get(arrays.get(arrays.size()-1)
.size()-1);
        for(int i = 0; i < arrays.size()-1; i++){
            max= Math.max(Math.abs(min- arrays.get(i).get(arrays.get(i).size()-1)), max);
             max= Math.max(Math.abs(min- arrays.get(i).get(0)), max);
           
        }
        
        return max;
    }
}