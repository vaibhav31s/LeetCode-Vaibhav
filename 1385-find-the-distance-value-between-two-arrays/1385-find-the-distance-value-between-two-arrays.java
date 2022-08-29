class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int yes = 0;
        int no = 0;
        
        for(int a : arr1){
           boolean satisfied = false;
            for(int b : arr2){
                if(Math.abs(a-b) <= d){
                   yes++;
                    satisfied = true;
                    break;
                }
            }
            if(!satisfied){
            no++;
                
            }
        }
        
        return no;
    }
}