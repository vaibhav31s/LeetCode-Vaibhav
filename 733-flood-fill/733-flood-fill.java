class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        dfs(image, sr, sc, color,image[sr][sc], image.length, image[0].length);
        return image;
    }
    
    void dfs(int[][] img, int i, int j,int color, int src,  int r, int c){
        if(i >= r || j >= c || i < 0 || j < 0 || img[i][j] == color) return;
        if(img[i][j] == src)
            img[i][j] = color;
        else return;
        dfs(img, i+1, j , color,src, r, c);
        dfs(img, i-1, j , color, src,r, c);
        dfs(img, i, j +1 , color,src, r, c);
        dfs(img, i, j -1 , color,src, r, c);

    }
}