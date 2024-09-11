class Solution {
    int totalTickets = 0;
    boolean isAnswerFound = false;
    public List<String> findItinerary(List<List<String>> tickets) {
        totalTickets = tickets.size();
      
        
        HashMap<String, List<String>> alist = new HashMap<>();
        
        for (List<String> edge : tickets) {
            String A = edge.get(0);
            String B = edge.get(1);
            //Since its A to B
            alist.putIfAbsent(A, new LinkedList<>());
            alist.get(A).add(B);
        }
        
        for (List<String> ma : alist.values()) {
            Collections.sort(ma);
        }
        List<String> answer = new ArrayList<>();
        
        travel(alist, "JFK", answer);
        return answer;
    }
    
    void travel(HashMap<String, List<String>> map, String from, List<String> answer) {
        List<String> neig = map.getOrDefault(from, new ArrayList<>());
        while(!neig.isEmpty()){
            String to = neig.remove(0);
            travel(map, to, answer);
        }
        answer.add(0,from);
    }
        
       
    
}