class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] answer = new char[s.length()];
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> p :  pairs){
            int x = p.get(0);
            int y = p.get(1);
            uf.union(x,y);
        }
        
        HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        
        int[] root = uf.root;
        for(int i = 0; i < s.length(); i++){
            int key = uf.find(i);
            if(!map.containsKey(key)){
                map.put(root[i],new ArrayList());
            }    
            map.get(key).add(i);
        }
        
        for(int key : map.keySet()){
            List<Character> temp = new ArrayList<>();
            PriorityQueue<Character> q = new PriorityQueue<>();
            for(int in :  map.get(key)){
                q.add(s.charAt(in));
            }
            for(int in :  map.get(key)){
                answer[in] = q.poll();
            }
            
            
        }
        
        
          
        return String.valueOf(answer);
    }
    
}
class Pair{
    List<Character> chars= new ArrayList();
    List<Integer> ints = new ArrayList();
    
}
class UnionFind{
    int[] root;
    int[] rank;
    UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    int find(int val){
        if(val == root[val]) return val;
        return root[val] = find(root[val]);
    }
    
     public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
             
            } else if (rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
              
            }else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
}