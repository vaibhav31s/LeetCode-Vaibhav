class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return go(books, shelfWidth, 0, 0, 0, new Integer[books.length]);
    }
    
   int go (int[][] books, int maxWidth, int ind, int curWidth, int maxHeight, Integer[] dp) {
       if (books.length <= ind) return 0;
       if (dp[ind] != null) return dp[ind];
       int min = Integer.MAX_VALUE;
       for (int i = ind; i < books.length; i++) {
           if (curWidth + books[i][0] <= maxWidth) {
               maxHeight = Math.max(maxHeight, books[i][1]);
               curWidth += books[i][0];
               min = Math.min(min, maxHeight + go(books, maxWidth, i + 1, 0, 0, dp));
           } else {
               
               break;
           }      
       }
       
       return dp[ind] = min;
    }
}