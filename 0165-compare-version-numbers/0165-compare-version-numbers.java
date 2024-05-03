class Solution {
    public int compareVersion(String version1, String version2) {
        Deque<Integer> dq1 = getList(version1);
        Deque<Integer> dq2 = getList(version2);
        
        while (!dq1.isEmpty() && !dq2.isEmpty()) {
            int f = dq1.poll();
            int s = dq2.poll();
            if (f < s) {
                return -1;
            } else if (f > s) {
                return 1;
            } 
        }
        
        while (!dq1.isEmpty()) {
            if (dq1.poll() == 0) continue;
            else return 1;
        }
        
        while (!dq2.isEmpty()) {
            if (dq2.poll() == 0) continue;
            else return -1;
        }
        return 0;
    }
    
    public Deque<Integer> getList(String version) {
        Deque<Integer> dq = new LinkedList<>();
        String[] v = version.split("\\.");
        
        for (String s : v) {
            StringBuilder sb = new StringBuilder();
            boolean zero = true;
            for (char ch : s.toCharArray()) {
                if (ch == '0' && !zero) {
                    sb.append(ch);
                } else if (ch != '0') {
                    sb.append(ch);
                    zero = false;
                }
            }
            if (sb.isEmpty()) {
               dq.add(0);
            } else {
                dq.add(Integer.parseInt(sb.toString()));
            }
        }
        return dq;
    }
}