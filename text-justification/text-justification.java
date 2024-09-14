class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        go(words, maxWidth, new ArrayList<>(), new ArrayList<>(), 0, 0);
        return answer;
    }
    
    void go(String[] words, int maxW, List<Integer> spaces, List<String> list,  int ind, int curTotal) {
        if (ind >= words.length) {
            lastwordJustification(spaces, list, curTotal, maxW);
            return;
        }
        // System.out.println(curTotal);
        String word = words[ind];
        if (list.isEmpty()) {
            list.add(word);
            curTotal += word.length();
            go(words, maxW, spaces, list, ind + 1, curTotal);
        } else if (curTotal + word.length() + 1 <= maxW) {
            spaces.add(1);
            curTotal = curTotal + word.length() + 1;
            list.add(word);
            go(words, maxW, spaces, list, ind + 1, curTotal);
        } else {
            build(spaces, list, curTotal, maxW);
            if (curTotal != 0) {
                go(words, maxW, new ArrayList<>(), new ArrayList<>(), ind , 0);
            } else {
                go(words, maxW, new ArrayList<>(), new ArrayList<>(), ind + 1, 0);
            }
            
        }
    }
    
    void build(List<Integer> spaces, List<String> words, int total, int maxW) {

        while (!spaces.isEmpty() && total < maxW) {
            for (int i = 0; i < spaces.size(); i++) {
                if (total >= maxW) break;
                spaces.set(i, spaces.get(i) + 1);
                total++;
                 if (total >= maxW) break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(spaces.size(), words.size()); i++) {
            sb.append(words.get(i));
            for (int j = 0; j < spaces.get(i); j++) {
                sb.append(" ");
            }
        }
        
        sb.append(words.get(words.size() - 1));
            
        for (int i = total; i < maxW; i++) {
            sb.append(" ");
        }
        answer.add(sb.toString());
    }
    
    void lastwordJustification(List<Integer> spaces, List<String> words, int total, int maxW) {

        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(spaces.size(), words.size()); i++) {
            sb.append(words.get(i));
            for (int j = 0; j < spaces.get(i); j++) {
                sb.append(" ");
            }
        }
        
        
        sb.append(words.get(words.size() - 1));
        
        for (int i = total; i < maxW; i++) {
            sb.append(" ");
        }
        answer.add(sb.toString());
    }
    
    
}
