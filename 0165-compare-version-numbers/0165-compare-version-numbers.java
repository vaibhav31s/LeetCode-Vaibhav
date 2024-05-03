class Solution {
    public int compareVersion(String version1, String version2) {
        Deque<Integer> dq1 = getVersionDeque(version1);
        Deque<Integer> dq2 = getVersionDeque(version2);
        
        while (!dq1.isEmpty() && !dq2.isEmpty()) {
            int first = dq1.poll();
            int second = dq2.poll();
            if (first < second) {
                return -1;
            } else if (first > second) {
                return 1;
            } 
        }
        
        while (!dq1.isEmpty()) {
            if (dq1.poll() != 0) {
                return 1;
            }
        }
        
        while (!dq2.isEmpty()) {
            if (dq2.poll() != 0) {
                return -1;
            }
        }
        return 0;
    }
    
    public Deque<Integer> getVersionDeque(String version) {
        Deque<Integer> dq = new LinkedList<>();
        String[] versionPart = version.split("\\.");
        
        for (String part : versionPart) {
            StringBuilder sb = new StringBuilder();
            boolean leadingZero = true;
            
            for (char ch : part.toCharArray()) {
                if (ch == '0' && !leadingZero) {
                    sb.append(ch);
                } else if (ch != '0') {
                    sb.append(ch);
                    leadingZero = false;
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