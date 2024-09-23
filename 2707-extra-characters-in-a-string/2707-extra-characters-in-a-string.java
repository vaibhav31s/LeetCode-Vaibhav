class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.buildTrie(str);
        }
        
        return go(s.toCharArray(), 0, trie.root, new Integer[100]);
    }
    
    int go(char[] arr, int ind, Node root, Integer[] dp) {
        Node temp = root;
        if (ind == arr.length) return 0;
        if (dp[ind] != null) return dp[ind];
        int min = 100;
        for (int i = ind; i < arr.length; i++) {
            int index = arr[i] - 'a';
            if ((temp.child[index]) == null) {
                min = Math.min(min, 1 + go(arr, ind + 1, root, dp));
                break;
            } else {
                temp = temp.child[index];
                if (temp.isEnd) {
                    min = Math.min(min, go(arr, i + 1, root, dp));
                } else {
                    min = Math.min(min, 1 + go(arr, ind + 1, root, dp));
                }
                
            }      
        }    
    
        return dp[ind] = min;
        
    }
    
    class Node {
        Node[] child = new Node[26];
        boolean isEnd = false;
    }
    
    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        
        void buildTrie(String s) {
            Node temp = root;
            for (char ch : s.toCharArray()) {
                int ind = ch - 'a';
                if (temp.child[ind] == null) {
                    temp.child[ind] = new Node();
                }
                temp = temp.child[ind];
            }
            temp.isEnd = true;
        }
    }
}