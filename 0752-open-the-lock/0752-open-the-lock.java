class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        int count = 0;
        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        Queue<String> dq = new LinkedList<>();
        dq.offer(start);
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                String last = dq.poll();
                
                if (deadEnds.contains(last)) 
                    continue;
                
                if (last.equals(target)) 
                    return count;
                
                for (int i = 0; i < last.length(); i++) {
                    String up = turnUp(last.toCharArray(), i, 1);
                    String down = turnUp(last.toCharArray(), i, 0);
                    
                    if (!deadEnds.contains(up)) dq.offer(up);
                    if (!deadEnds.contains(down)) dq.offer(down);
                }
                deadEnds.add(last); 
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