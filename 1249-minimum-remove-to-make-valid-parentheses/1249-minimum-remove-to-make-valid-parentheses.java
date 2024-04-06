class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                sb.append(ch);
                list.add(sb.length() -1 );
            } else if (ch == ')') {
                count--;
                if (count >= 0) {
                    sb.append(ch);
                } else count = 0;
            } else {
                sb.append(ch);
            }
        }
    
        int j = 0;
        list.sort(Collections.reverseOrder());
        
        while (count > 0) {
            sb.deleteCharAt(list.get(j));
            j++;
            count--;
        }
        
        return sb.toString();
    }
}