class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n  = picture.length;
        int m = picture[0].length;
        HashMap<Integer, HashMap<Character, Integer>> rows =  new HashMap<>();
        for(int i = 0; i < n; i++){
            rows.put(i, new HashMap<>());
            HashMap<Character, Integer> row  = rows.get(i);
            for(char ch : picture[i]) row.put(ch, row.getOrDefault(ch, 0 )+1);
        }
        
        HashMap<Integer, HashMap<Character, Integer>> cols =  new HashMap<>();
        for(int i = 0; i < m; i++){
            cols.put(i, new HashMap<>());
            HashMap<Character, Integer> col  = cols.get(i);
            
            for(int j = 0; j < n; j++){
                char ch = picture[j][i]; 
                col.put(ch, col.getOrDefault(ch, 0 )+1);
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(picture[i][j] == 'B'){
                    if(rows.get(i).get('B') == 1 && cols.get(j).get('B') == 1) answer++;
                }
            }
        }
        
        
        return answer;
        
        
    }
}