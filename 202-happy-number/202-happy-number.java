class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        int prev = n;
        while(n != 1){
            if(set.contains(n)) return false;
            
            set.add(n);
            
            int sum = 0;
            int temp = n;
            while(temp > 0){
                int last = temp % 10;
                sum += last * last;
                temp/=10;
            }
            n = sum;
        }
    
        
        return true;
    }
}