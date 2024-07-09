class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitingTime = 0.0;
        double curTime = 0.0;
        for (int[] customer : customers) {
            if (curTime < customer[0]) {
                curTime = customer[0] + customer[1];
            } else {
                curTime += customer[1];
            }
            waitingTime += curTime - customer[0];
        }
        return waitingTime / customers.length;
    }
}
