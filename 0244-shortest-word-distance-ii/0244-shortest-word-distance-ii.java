class WordDistance {
    HashMap<String, TreeSet<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String w = wordsDict[i];
            map.putIfAbsent(w, new TreeSet<>());
            map.get(w).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        TreeSet<Integer> first = map.get(word1);
        TreeSet<Integer> second= map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int a : first){
            Integer l = second.lower(a);
            Integer h = second.higher(a);
            if(l != null){
                min = Math.min(min,Math.abs(a-l));
            }
            if(h != null){
                min = Math.min(min,Math.abs(a-h));
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */