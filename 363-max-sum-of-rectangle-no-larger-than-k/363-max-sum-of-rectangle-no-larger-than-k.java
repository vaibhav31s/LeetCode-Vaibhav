class Solution {
    public int maxSumSubmatrix(int[][] grid, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            int a[]=new int[m];
            for(int j=i;j<n;j++)
            {
                for(int x=0;x<m;x++)
                a[x]+=grid[j][x];
                
                int sum=helper(a,k);
                max=Math.max(max,sum);
            }
        }
        
        return max;
    }
    
    public int helper(int a[],int k)
    {
        int ans=Integer.MIN_VALUE;
        
        for(int i=0;i<a.length;i++)
        {
            int s=0;
            for(int j=i;j<a.length;j++)
            {
                s+=a[j];
                if(s<=k)
                ans=Math.max(ans,s);
            }
        }
        
        return ans;
    }
}