class Solution {
   public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int answer = 0;
        SegmentTree seg = new SegmentTree(0, nums.length);

        for (int i = 0; i < nums.length; i++) seg.update(i, nums[i]);

         int i = 0;
        int j = 0;
        while (j < nums.length ) {
            while (i <= j && seg.query(i, j) >= k) {
                i++;
            }
            
            answer += (j - i + 1);
            j++;
        }
        return answer;
    }
 private static int numberOfSubs(int N) {
        return N * (N + 1) / 2;
    }
    private static class SegmentTree
    {
        //Tlatoani's segment tree
        //iterative implementation = low constant runtime factor
        //range query, non lazy
        final int[] val;
        final int treeFrom;
        final int length;

        public SegmentTree(int treeFrom, int treeTo)
        {
            this.treeFrom = treeFrom;
            int length = treeTo - treeFrom + 1;
            int l;
            for (l = 0; (1 << l) < length; l++);
            val = new int[1 << (l + 1)];
            Arrays.fill(val, 1);
            this.length = 1 << l;
        }
        public void update(int index, int delta)
        {
            //replaces value
            int node = index - treeFrom + length;
            val[node] = delta;
            for (node >>= 1; node > 0; node >>= 1)
                val[node] = comb(val[node << 1], val[(node << 1) + 1]);
        }
        public int query(int from, int to)
        {
            //inclusive bounds
            if (to < from)
                return 0; //0 or 1?
            from += length - treeFrom;
            to += length - treeFrom + 1;
            //0 or 1?
            int res = 1;
            for (; from + (from & -from) <= to; from += from & -from)
                res = comb(res, val[from / (from & -from)]);
            for (; to - (to & -to) >= from; to -= to & -to)
                res = comb(res, val[(to - (to & -to)) / (to & -to)]);
            return res;
        }
        public int comb(int a, int b)
        {
            //change this
            return a * b;
        }
    }
    
}