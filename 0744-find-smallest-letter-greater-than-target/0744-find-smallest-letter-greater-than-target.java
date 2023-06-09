class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target == 'z') {target = 'a'-1;
                        
                          }

        
        int ans=  upper_bound(letters, target);
        if(ans == -1){
            return letters[0];
        }
        return letters[ans % letters.length];
    }
     public static int upper_bound(char[] ar,char k)
            {
                int s=0;
                int e=ar.length;
                while (s !=e)
                {
                    int mid = s+e>>1;
                    if (ar[mid] <= k)
                    {
                        s=mid+1;
                    }
                    else
                    {
                        e=mid;
                    }
                }
                
                return s;
            }
        
}