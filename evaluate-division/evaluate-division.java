class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> alist = new HashMap<>();
        HashSet<Integer> allKey = new HashSet<>();
        
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            Double val = values[i];
            
            alist.putIfAbsent(a, new ArrayList<>());
            alist.putIfAbsent(b, new ArrayList<>());
            
            alist.get(a).add(new Pair(b, val));
            alist.get(b).add(new Pair(a, 1.0 / val));
        }
        
        
        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> q : queries) {
            res[i++] = dijikstra(alist, q.get(0), q.get(1));
        }
        return res;
    }
  
    
    double dijikstra(HashMap<String, List<Pair>> alist, String src, String dest) {
        
        if (!alist.containsKey(src) || !alist.containsKey(dest)) return -1.0;

        HashMap<String, Double> distance = new HashMap<>();
    
        for (String key : alist.keySet()) {
            distance.put(key, Double.MAX_VALUE);
        }
    
        
        Deque<Pair> dq = new LinkedList<>();
        dq.add(new Pair(src, 1.0));
        
        while (!dq.isEmpty()) {
            Pair last = dq.poll();
            String node = last.getKey();
            Double weight = last.getValue();
            

            
            if (!alist.containsKey(node)) continue;
            for (Pair child : alist.get(node)) {
                
                
                double newWeight = child.getValue() * weight;
                
                if (distance.containsKey(child.getKey()) && newWeight < distance.get(child.getKey())) {
                    distance.put(child.getKey(), newWeight);
                    dq.add(new Pair(child.getKey(), newWeight));
                }
            }
        }
        
        Double destWeight = distance.get(dest);
        if (destWeight == Double.MAX_VALUE) return -1.0;
        
        return destWeight;
    }
    
    class Pair {
        String node;
        Double weight;
        Pair(String node, Double weight) {
            this.node = node;
            this.weight = weight;
        }
        
        void updateWeight(Double weight) {
            this.weight = weight;
        }
        
        double getValue() {
            return weight;
        }
        
        String getKey() {
            return node;
        }
    }
}