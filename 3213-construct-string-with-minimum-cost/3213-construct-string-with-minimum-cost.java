class Solution {
     public static int minimumCost(String target, String[] words, int[] costs) {

        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.insert(words[i], costs[i]);
        }
//         long answer = go(target, 0, t, new HashMap<>());
//          if (answer == Integer.MAX_VALUE) return -1;
//         return (int) answer;
         int n = target.length();
         HashMap<Integer, Long> dp = new HashMap<>();
         
         dp.put(n, 0L);
         
         for (int j = n - 1; j >= 0; j--) {
              Node temp = t.root;
                long min = Integer.MAX_VALUE;
              if (dp.containsKey(j)) {
                  continue;
              }
             for (int i = j; i < target.length(); i++) {
                if (temp.arr[target.charAt(i) - 'a'] == null) {
                   break;
                }
                temp = temp.arr[target.charAt(i) - 'a'];
                if (temp.isEnd) {
                    long val = temp.val + dp.get(i + 1);
                    min = Math.min(min, val);
                }
            }
             dp.put(j, min);
         }
         long ans =  dp.get(0);
         if (ans == Integer.MAX_VALUE) return -1;
         return (int) ans;
         
    }

    private static long go(String target, int ind, Trie root, HashMap<Integer, Long> dp) {
        if (ind == target.length() ) return 0;

        Node temp = root.root;
        long min = Integer.MAX_VALUE;
        
        if (dp.containsKey(ind)) return dp.get(ind);
        for (int i = ind; i < target.length(); i++) {
            if (temp.arr[target.charAt(i) - 'a'] == null) {
               break;
            }
            temp = temp.arr[target.charAt(i) - 'a'];
            if (temp.isEnd) {
                long val = temp.val + go(target, i + 1, root,dp);
                min = Math.min(min, val);
            }
        }
        
        dp.put(ind, min);
        
        return min;
    }

    private static class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }

        public void insert(String word, int val) {
            Node temp = root;
            for(char ch : word.toCharArray()){
                int index=  ch - 'a';
                if(temp.arr[index]==null){
                    temp.arr[index] = new Node();
                }

                temp = temp.arr[index];

            }
            temp.isEnd = true;
            temp.val = Math.min(temp.val,val);
        }

        public int search(String word) {
            Node temp = root;
            for(char ch : word.toCharArray()){
                int index=  ch - 'a';
                if(temp.arr[index]==null) return -1;

                temp = temp.arr[index];
            }

            return temp.val;

        }

        public boolean startsWith(String word) {
            Node temp = root;
            for(char ch : word.toCharArray()){
                int index=  ch - 'a';
                if(temp.arr[index]==null)return false;

                temp = temp.arr[index];
            }
            return true;

        }
    }
     private static class Node{
        Node[] arr=  new Node[26];
        boolean isEnd = false;
        int val = Integer.MAX_VALUE;

    }
}