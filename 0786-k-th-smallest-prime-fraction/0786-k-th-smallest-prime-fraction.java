class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Pair<Double, Pair<Integer, Integer>>> pq = new PriorityQueue<>((a, b) -> Double.compare(a.getKey(), b.getKey()));
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Pair((double) arr[i] / arr[j], new Pair(arr[i], arr[j])));
            }
        }
        while (k-- > 1) {
            pq.poll();
        }
            
        return new int[]{pq.peek().getValue().getKey(), pq.peek().getValue().getValue()};
    }
}

// 1 2 3 5

    
// 1/5 = 0.2
// 1/3 = 0.33
// 1/2 = 0.5
// 2/5 = 0.4
// 2/3 = 0.66
// 3/5 = 0.6

// 1/1 = 1
// 2/2 = 1
// 5/5 = 1
// 3/3 = 1

