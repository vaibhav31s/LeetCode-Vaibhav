class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitingTime = 0.0;
        double curTime = customers[0][0] + customers[0][1];
        waitingTime += curTime - customers[0][0];
        for (int i = 1; i < customers.length; i++) {
            if (curTime < customers[i][0]) {
                curTime = customers[i][0] + customers[i][1];
                waitingTime += curTime - customers[i][0];
            } else {
                curTime += customers[i][1];
                waitingTime += curTime - customers[i][0];
            }

        }
        
        return waitingTime / customers.length;
    }
}
