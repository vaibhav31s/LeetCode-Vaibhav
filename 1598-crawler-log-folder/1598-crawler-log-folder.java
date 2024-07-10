class Solution {
    public int minOperations(String[] logs) {
        int max = 0;
        int depth = 0;
        for (String x : logs) {
            if (x.equals("../")) {
                if (depth == 0) {
                    depth = 0;
                } else 
                    depth--;
            } else if (x.equals("./")) {
                
            } else {
                depth++;
            }
            max = Math.max(max, depth);
        }
        return depth;
    }
}