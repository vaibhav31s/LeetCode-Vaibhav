class Solution {
    public int findMaxLength(int[] nums) {
        int[] pref = new int[nums.length + 1];
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 1) count++;
            pref[i] = count;
        }

        
        int max = nums.length + 1;
        while (max-- > 0) {
            if (max % 2 == 1) 
                continue;
            // System.out.println(max + " " + slide(pref, max));
            if (slide(pref, max)) {
                return max;
            }
        }
        return 0;
    }
    
    boolean slide(int[] pref, int win) {
        for (int i = 0; i < pref.length - win; i++) {
            int one = pref[i + win] - pref[i];
            // System.out.println(one + " " + win);
            if (one + one == win) return true;
        }
        
        return false;
    }
}