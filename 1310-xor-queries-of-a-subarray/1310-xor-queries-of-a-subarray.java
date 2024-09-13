class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefXOR = new int[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            prefXOR[i] = prefXOR[i - 1] ^ arr[i - 1];
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[1] + 1, right = query[0];
            answer[i] = prefXOR[left] ^ prefXOR[right];
        }
        return answer;
    }
}

