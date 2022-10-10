class Solution {
    public int countBinarySubstrings(String s) {
    
        List<Integer> groupBy = new ArrayList<>();

        char last = 0;
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i- 1) ==  s.charAt(i)){
                  count++;  
            }else{
                groupBy.add(count);
                count= 1;
            }
        }
        int answer =0;
        groupBy.add(count);
        for(int i  = 1 ; i< groupBy.size(); i+=1){
            answer += Math.min(groupBy.get(i-1),groupBy.get(i));
        }
        System.out.println(groupBy);

return answer;
    }
}