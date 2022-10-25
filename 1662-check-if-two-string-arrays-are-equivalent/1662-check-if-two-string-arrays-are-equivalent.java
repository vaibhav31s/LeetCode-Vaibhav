class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
     StringBuilder sb1 = new StringBuilder();
     StringBuilder sb2 = new StringBuilder();
        
        for(String x : word1) sb1.append(x);
        for(String x : word2) sb2.append(x);
        
        return sb1.toString().equals(sb2.toString());
        
    }
}