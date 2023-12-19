class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] answer = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                  answer[i][j] =(int) Math.floor((img[i][j] + allFourMatrix(img, i, j)) / (len(img, i, j) + 1));
            }
        }
        return answer;
    }
    private static int allFourMatrix(int[][] arr, int i, int j) {
        int n = arr.length;
        int m = arr[i].length;
        int left = (i - 1) < 0 ? 0 : (arr[i - 1][j]);
        int right = (i + 1) >= n ? 0 : (arr[i + 1][j]);
        int up = (j - 1) < 0 ? 0 : (arr[i][j - 1]);
        int down = (j + 1) >= m ? 0 : (arr[i][j + 1]);
        
        int leftup = (((i - 1) < 0) || (j - 1) < 0 ) ?  0 : arr[i - 1][j-1];
        int leftdown = (((i - 1) < 0) || (j + 1) >= m ) ?  0 : arr[i - 1][j+1];
        int rightup = (((i + 1) >= n ) || (j - 1) < 0 ) ?  0 : arr[i + 1][j-1];
        int rightdown = (((i + 1) >= n ) || (j + 1) >= m ) ?  0 : arr[i + 1][j+1];
        
        return left + right + up + down + leftup + leftdown + rightup + rightdown;
    }
    private static int len(int[][] arr, int i, int j) {
         int n = arr.length;
        int m = arr[i].length;
        int left = (i - 1) < 0 ? 0 : 1;
        int right = (i + 1) >= n ? 0 : 1;

        int up = (j - 1) < 0 ? 0 :  1 ;
        int down = (j + 1) >= m ? 0 : 1;
        
         int leftup = (((i - 1) < 0) || (j - 1) < 0 ) ?  0 :1;
        int leftdown = (((i - 1) < 0) || (j + 1) >= m ) ?  0 : 1;
        int rightup = (((i + 1) >= n ) || (j - 1) < 0 ) ?  0 : 1;
        int rightdown = (((i + 1) >= n ) || (j + 1) >= m ) ?  0 : 1;
        return left + right + up + down + leftup + leftdown + rightup + rightdown;
    }
    
}