class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int last = Integer.MIN_VALUE;
        int count = 0;
        int total =(int) Math.floor((double)nums.length/3.0);
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int x : nums) {
            if(last == x) count++;
            else {
                if (count > total) {
                   answer.add(last); 
                }
                count = 1;
            }
            
            
            last = x;
        }
        
        // System.out.println(last + " - " + count);
        if (count > total) {
            answer.add(last); 
        }
        
        
        return answer;
    }
}