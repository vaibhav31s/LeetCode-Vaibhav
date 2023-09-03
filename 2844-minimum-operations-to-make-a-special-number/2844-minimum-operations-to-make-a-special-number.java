class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    public int minimumOperations(String num) {
        return go(num.toCharArray(), 0, 0);
        
    }
    
    int go(char[] numbers, int index, int modedValue) {
        if(index == numbers.length)
        {
            if (modedValue==0) return 0;
            return 1001;
        }
        
        String key = index + "-" + modedValue;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int number = numbers[index] - '0';
        int pick =  go(numbers, index + 1, (modedValue * 10 + number) % 25 );
        int notPick = 1 + go(numbers, index + 1, modedValue);
        
        int val = Math.min(pick, notPick);
        memo.put(key, val);
        return val;
    }
   
    
}