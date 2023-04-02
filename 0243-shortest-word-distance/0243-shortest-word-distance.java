class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        TreeSet<Integer> first = new TreeSet<>();
        TreeSet<Integer> second = new TreeSet<>();
        
        for(int i = 0; i < wordsDict.length; i++){
            String a = wordsDict[i];
            if(a.equals(word1)) first.add(i);
            if(a.equals(word2)) second.add(i);
            
        }
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