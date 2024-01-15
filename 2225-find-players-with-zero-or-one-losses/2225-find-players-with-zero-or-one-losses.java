class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer, Integer> looser = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int[] match :  matches) {
            int win = match[0];
            int loose = match[1];
            set.add(win);
            set.add(loose);
            looser.put(loose, looser.getOrDefault(loose, 0) + 1);
        
        }
        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();
        for (int x : set) {
            if(looser.containsKey(x)) {
                if(looser.get(x) == 1) answer1.add(x);
            } else {
                answer0.add(x);
            }
        }
        
        answer.add(answer0);
        answer.add(answer1);
        return answer;
    }
}