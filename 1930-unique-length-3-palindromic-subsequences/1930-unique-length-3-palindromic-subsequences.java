class Solution {
    public int countPalindromicSubsequence(String s) {
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            positions.add(new ArrayList<>());
        }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            positions.get(index).add(i);
        }
        
        int answer = 0;
        
        for (int i = 0; i < 26; i++) {
            int size = positions.get(i).size();
            if (positions.get(i).size() <= 1) continue;
            int start = positions.get(i).get(0);
            int end = positions.get(i).get(size - 1);
               
            for (int j = 0; j < 26; j++) {
                int upper = upper_bound(positions.get(j), start);
                int lower = lower_bound(positions.get(j), end);
                
                if (upper != -1 && upper > start && upper < end) {
                    answer++;
                }
                else
                if (lower != -1 && lower > start && lower < end) {
                    answer++;
                }
                // System.out.println(upper + " " + lower);
            }
        }
        
        
        return answer;
    }
    
    
         public static int upper_bound(ArrayList<Integer> ar,int k)
            {
                int s=0;
                int e=ar.size();
                while (s !=e)
                {
                    int mid = s+e>>1;
                    if (ar.get(mid) <=k)
                    {
                        s=mid+1;
                    }
                    else
                    {
                        e=mid;
                    }
                }
                if(s==ar.size())
                {
                    return -1;
                }
                return ar.get(s);
            }

        public static int lower_bound(ArrayList<Integer>  ar,int k)
        {
            int s=0;
            int e=ar.size();
            while (s !=e)
            {
                int mid = s+e>>1;
                if (ar.get(mid) <k)
                {
                    s=mid+1;
                }
                else
                {
                    e=mid;
                }
            }
            if(s==ar.size())
            {
                return -1;
            }
            return ar.get(s);
        }
}