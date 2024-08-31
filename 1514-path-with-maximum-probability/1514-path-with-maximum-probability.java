class Solution {
    double ans = 0.0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair<Integer, Double>>> alist = new ArrayList<>();
        for (int i = 0; i < n; i++) alist.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] x = edges[i];
            alist.get(x[0]).add(new Pair<>(x[1], succProb[i]));
            alist.get(x[1]).add(new Pair<>(x[0], succProb[i]));
        }
        
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()) );
        double[] maxValue = new double[n];
        pq.add(new Pair<>(start_node, 1.0));
        while (!pq.isEmpty()) {
            Pair<Integer, Double> biggest = pq.poll();
            for (Pair<Integer, Double> node : alist.get(biggest.getKey())) {
                double curValue = biggest.getValue() * node.getValue();
                if (maxValue[node.getKey()] < curValue) {
                    maxValue[node.getKey()] = curValue;
                    pq.add(new Pair<>(node.getKey(), curValue));
                }
            }
        }
        
        return maxValue[end_node];
    }
}
        