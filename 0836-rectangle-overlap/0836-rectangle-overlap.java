class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1  = rec1[0];
        int ax2  = rec1[2];
        int ay1  = rec1[1];
        int ay2  = rec1[3];
        
         int bx1  = rec2[0];
        int bx2  = rec2[2];
        int by1  = rec2[1];
        int by2  = rec2[3];
        
        
           int xoverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yoverlap = Math.min(ay2, by2)  - Math.max(ay1, by1);
        
        
        
        if(xoverlap > 0 && yoverlap > 0){
            return true;
        }
        return false;
    }
}