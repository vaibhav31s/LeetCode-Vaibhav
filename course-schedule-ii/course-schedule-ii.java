class Solution {
  public int[] findOrder(int n, int[][] relations) {
    int[] indegree = new int[n];
    int[] answer = new int[n];
    int count = 0;
    HashMap < Integer, HashSet < Integer >> alist = new HashMap < > ();
    for (int i = 0; i < n; i++) {
      alist.put(i, new HashSet < > ());
    }

    for (int[] x: relations) {
      alist.get(x[0]).add(x[1]);
    }

    for (int i = 0; i < n; i++) {
      indegree[i] = alist.get(i).size();
    }

    // System.out.println(alist);

    // System.out.println(Arrays.toString(indegree));

    Deque < Integer > dq = new LinkedList < > ();

    do {

      int nn = dq.size();
      while (nn--> 0) {
        int a = dq.poll();
        indegree[a]--;
        for (int i = 0; i < n; i++) {
          if (alist.get(i).contains(a)) indegree[i]--;
        }
        answer[count] = a;
        count++;
      }

      for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
          dq.add(i);
        }

      }
      if (dq.size() == 0 && count != n) return new int[0];

    } while (!dq.isEmpty());

    return answer;
  }
}