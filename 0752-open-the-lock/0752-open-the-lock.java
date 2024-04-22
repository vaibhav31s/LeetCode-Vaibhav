class Solution {
    public int openLock(String[] deadends, String target) {
        String sb = "0000";
        int count = 0;
        Deque<String> dq = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> find = new HashSet<>();
        for (String x :  deadends) find.add(x);
        dq.add("0000");
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                String last = dq.poll();
                // System.out.println(last);
                if (set.contains(last) || find.contains(last)) continue;
                if (last.equals(target)) return count;
                for (int i = 0; i < last.length(); i++) {
                    dq.add(turnUp(last.toCharArray(), i, 1));
                    dq.add(turnUp(last.toCharArray(), i, 0));
                }
                set.add(last); 
            }
        
            count++;
        }
        
        return -1;
    }
    String turnUp(char[] arr, int ind, int dir) {
        if (arr[ind] == '9' && dir == 1) arr[ind] = '0';
        else
        if (arr[ind] == '0' && dir == 0) arr[ind] = '9';
        else if (dir == 0) {
            arr[ind] = (char) (arr[ind] - 1);
        } else {
            arr[ind] = (char) (arr[ind] + 1);
        }
        return String.valueOf(arr);
    }
}