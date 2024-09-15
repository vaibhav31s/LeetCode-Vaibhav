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
        
        for (List<String> list : alist.values()) {
            Collections.sort(list);
        }
        
        List<String> answer = new ArrayList<>();
        travel(alist, "JFK", answer);
        return answer;
    }
    
    boolean flag = false;
    void travel(HashMap<String, List<String>> alist , String curStation, List<String> answer) {
        List<String> childs = alist.getOrDefault(curStation, new ArrayList<>());
        
        while(!childs.isEmpty()) {
            String child = childs.get(0);
            childs.remove(0);
            travel(alist, child, answer);
        }
        
        answer.add(0, curStation);
       
    }
    
   
    
}