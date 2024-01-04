class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        int max =0;
        for(int x : map.values()) {if(x == 1) return -1;
                   max = Math.max(max, x);               
                                  }
        int min = 0;
        System.out.println(map);
        int[] memo = new int[max+5];
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;
        for(int i = 6; i <= max; i++) {
            memo[i] = 1 + Math.min(memo[i - 2], memo[i-3]);
        }
        for(int x : map.values()) {
            min += memo[x];
        }
        return min;
    }
}

// 1 = 0
// 2 = 1
// 3 = 1
// 4 = 2
// 5 = 2
// 6 = 2
// 7 = 3
// 8 = 3
// 9 = 3
// 10 = 4
    
//     0 1 1 2 2 2 3 3 3 4
    

