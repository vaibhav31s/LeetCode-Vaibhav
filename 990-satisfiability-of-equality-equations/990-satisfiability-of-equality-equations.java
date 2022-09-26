class Solution {
    public boolean equationsPossible(String[] equations) {
        unionFind uf = new unionFind();
        for(String s : equations){
            int first = s.charAt(0) - 'a';
            int second = s.charAt(3) - 'a';
            char sign = s.charAt(1);
            if(sign == '='){
                uf.union(first, second);
            }else{
                uf.union(first, first);
                uf.union(second, second);
            }
            
        }
        for(String s : equations){
            int first = s.charAt(0) - 'a';
            int second = s.charAt(3)- 'a';
            char sign = s.charAt(1);
            if(sign == '='){
                if(!uf.isConnected(first, second)) return false;
            }else{
                 if(uf.isConnected(first, second)) return false;
            }
        }
            return true;
    
    }
}
class unionFind{
    int[] root = new int[27];
    unionFind(){
        for(int i = 0; i< 26; i++){
            root[i] = i;
        }
    }
        int find(int x){
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }
    boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
             if (rootX == rootY) 
                    return false;
    
            root[rootY] = rootX;
            return true;
        }
    boolean isConnected(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        return rootx == rooty;
    }
}
    
    
