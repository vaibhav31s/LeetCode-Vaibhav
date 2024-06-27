class Solution {
    public int findCenter(int[][] edges) {
        int answer = 0;
        for (int i = 1; i < edges.length; i++) {
            int a = edges[i - 1][0];
            int b = edges[i - 1][1];
            int c = edges[i][0];
            int d = edges[i][1];
            
            if (a == c || a == d) answer = a;
            if (b == c || b == d) answer = b;
        }
        
        return answer;
    }
}