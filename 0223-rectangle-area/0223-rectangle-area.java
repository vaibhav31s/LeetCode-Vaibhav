class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaFirst =  (ay2 - ay1) * (ax2 - ax1);
        int areaSecond =  (by2 - by1) * (bx2 - bx1);
        
        int xoverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yoverlap = Math.min(ay2, by2)  - Math.max(ay1, by1);
        
        
        int overlap = 0;
        if(xoverlap > 0 && yoverlap > 0){
            overlap = xoverlap * yoverlap;
        }
        return (areaFirst + areaSecond )- overlap;
    }
}