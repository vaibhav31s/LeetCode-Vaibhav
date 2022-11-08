class Solution {
    public int minimumSemesters(int n, int[][] relations) {
       int[] indegree = new int[n+1];
    int[] answer = new int[n+1];
    int count = 1;
    HashMap < Integer, HashSet < Integer >> alist = new HashMap < > ();
    for (int i = 1; i <= n; i++) {
      alist.put(i, new HashSet < > ());
    }
indegree[0]=-1;
    for (int[] x: relations) {
      alist.get(x[0]).add(x[1]);
    }

    for (int i = 1; i <= n; i++) {
      indegree[i] = alist.get(i).size();
    }

//     System.out.println(alist);

//     System.out.println(Arrays.toString(indegree));
int ans = 0;
    Deque < Integer > dq = new LinkedList < > ();

    do {

      int nn = dq.size();
      while (nn--> 0) {
        int a = dq.poll();
        indegree[a]--;
        for (int i = 1; i <= n; i++) {
          if (alist.get(i).contains(a)) indegree[i]--;
        }
        answer[count] = a;
        count++;
      }

      for (int i = 1; i <= n; i++) {
        if (indegree[i] == 0) {
          dq.add(i);
        }

      }
      if (dq.size() == 0 && count != n+1) return -1;
ans++;
        
        
    } while (!dq.isEmpty());
        
    return ans - 1;
    }
    
}
