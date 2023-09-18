class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.getValue() ==  b.getValue()) return a.getKey() - b.getKey();
                return a.getValue() - b.getValue();
            }                                                       
        );
        
        for (int i = 0; i < mat.length; i++) 
            pq.add(new Pair(i,  binarySearch(mat[i])));
        
        int[] answer = new int[k];
        int i = 0;
        while (k-- > 0) {
            answer[i++] = pq.poll().getKey();
        }
        return answer;
    }
    
    int binarySearch(int[] mat) {
        int start = 0;
        int end = mat.length - 1;
        int answer = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(mat[mid] == 0) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
        // System.out.println(answer);
        return answer;
        
    }
}