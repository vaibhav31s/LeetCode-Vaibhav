class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] r) {
        List<List<Integer>> answer = new ArrayList<>();
        int istart = r[0];
        int iend = r[1];
        
            
        for(int[] x : intervals){
            int xstart = x[0];
            int xend = x[1];
            
           if(xstart > iend || xend < istart){
               answer.add(getpoints(xstart, xend));
           }else{
               if(xstart < istart){
                   answer.add(getpoints(xstart, istart));
               }
               if(xend > iend){
                   answer.add(getpoints(iend, xend));
               }
           }
            
        }
        
        
        return answer;
    }
    
    List<Integer> getpoints(int a, int b){
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        return list;
    }
}