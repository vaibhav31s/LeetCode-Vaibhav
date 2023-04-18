class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int gretestAmongAll = 0;
        
        for(int kid :  candies){
            gretestAmongAll = Math.max(gretestAmongAll, kid);
        }
        
        List<Boolean> answer = new ArrayList<>();
        
        for(int kid :  candies){
            int afterExtra =kid +  extraCandies;
            if(afterExtra >= gretestAmongAll) answer.add(true);
            else answer.add(false);
        }
        
        return answer;
    }
}
