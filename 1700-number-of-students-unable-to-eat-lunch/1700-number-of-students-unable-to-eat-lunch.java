class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stud = new LinkedList<>();
        int stack = 0;
        
        for (int i = students.length - 1; i >= 0; i--) stud.add(students[i]);
        
        int count = 0;
        while (stack < sandwiches.length) {
            int cur = sandwiches[stack];
            
            if (stud.peek() == cur) {
                stud.pollFirst();
                stack++;
                count = 0;
            } else {
                int first = stud.pollFirst();
                stud.add(first);
                count++;
            }
            
            
            if (count >= students.length - stack) break;
        
        }
        
        return students.length - stack;
    }
}