class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] s) {
        // List<List<Integer>> answer =new AR
         int size = s.length;
        for(int i = 0; i <= Math.pow(2,size)-1; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int k = 0; k < 32; k++){
                int mask = 1 << k;
                if((i &  mask) != 0){
                    list.add(s[k]);
                }
            }
           answer.add(list);
        }
        return answer;
    }
    void subsetMaker(int[] nums, boolean[] vis, List<Integer> list, int index){
        if(index == vis.length )return;
        answer.add(new ArrayList<>(list));
        
         for(int i = index; i < vis.length; i++){
            if(!vis[i]){
                list.add(nums[i]);
                vis[i] = true;
                subsetMaker(nums, vis, list,i);
                list.remove(list.size()-1);
                vis[i] = false;
            }


        }
        
        
    }
}