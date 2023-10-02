class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, countA = 0, countB = 0;
        for (char ch : colors.toCharArray()) {
            if (ch == 'A') {
                countA++;
                countB = 0;
            } else {
                countB++;
                countA = 0;
            }

            alice += (countA >= 3) ? 1 : 0;
            bob += (countB >= 3) ? 1 : 0;
        }

        return alice > bob;
    }
}


