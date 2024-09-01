class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] newArray = new int[m][n];

        int pointerRow = 0, pointerCol = 0;
        
        if (m * n != original.length) return new int[][]{};

        for (int i = 0; i < original.length; i++) {
            int curElement = original[i];
            if (pointerCol == n) {
                pointerCol = 0;
                pointerRow++;
            }

            newArray[pointerRow][pointerCol] = curElement;
            pointerCol++;
        }

        return newArray;
    }
}