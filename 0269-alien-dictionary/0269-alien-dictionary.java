class Solution {
    public String alienOrder(String[] words) {
        List<HashSet<Integer>> alist = new ArrayList<>();
        for (int i = 0; i < 26; i++) alist.add(new HashSet<>());
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);


        
        for (int j = 0; j < words.length - 1; j++) {
            String first = words[j];
            String second = words[j + 1];
            int gg= Math.min(first.length(), second.length());
            if (first.substring(0, gg).equals(second.substring(0, gg))) {

                if (first.length() > second.length()) {
                    return "";
                }
            }
            
            for (int i = 0; i < gg; i++) {
                int from = first.charAt(i) - 'a';
                int to = second.charAt(i) - 'a';
                if (from != to) {
                    if (alist.get(from).contains(to)) {
                        break;
                    }
                    alist.get(from).add(to);
                    if (inDegree[from] == -1) 
                        inDegree[from] = 0;
                    if (inDegree[to] == -1) 
                        inDegree[to] = 0;
                    
                    inDegree[to]++;
                    break;
                    
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (String s : words) {
            for (char ch : s.toCharArray()) {
                int ind = ch - 'a';
                set.add(ind);
            }
        }
        
        for (int x : set) {
            if (inDegree[x] == -1) {
                inDegree[x] = 0;
            }
        }
        
        
        
        System.out.println(alist);
          
        System.out.println(Arrays.toString(inDegree));  
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }    
        }
        

        while (!dq.isEmpty()) {
            int curNode = dq.poll();
            inDegree[curNode]--;
            sb.append((char)(curNode + 'a'));
            for (int x : alist.get(curNode)) {
                inDegree[x]--;
                if (inDegree[x] == 0) {
                    dq.add(x);
                }
            }
        }
        
        if (sb.length() != set.size()) return "";
        
        return sb.toString();
    }
}

//wrt w -> r -> t