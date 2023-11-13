class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> stops = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            for(int x : routes[i]) {
                stops.putIfAbsent(x, new ArrayList<>());
                stops.get(x).add(i);
            }
        }
        
        
        int answer = 0;
        Deque<Integer> dq = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> vistedBus = new HashSet<>();
        dq.add(source);
        while(!dq.isEmpty()) {
            int size = dq.size();
            while(size-- > 0) {
                int stop = dq.poll();
                if(target == stop) return answer;
                if(visitedStops.contains(stop) || !stops.containsKey(stop)) continue;
                visitedStops.add(stop);
                ArrayList<Integer> buses = stops.get(stop);
                for(int bus :  buses){
                    if(vistedBus.contains(bus)) continue;
                    vistedBus.add(bus);
                    for (int nextStop : routes[bus]) {
                        if(visitedStops.contains(nextStop)) continue; 
                        dq.add(nextStop);
                    }
                }
            }
            answer++;
        }
        
        return -1;
        
    }
}