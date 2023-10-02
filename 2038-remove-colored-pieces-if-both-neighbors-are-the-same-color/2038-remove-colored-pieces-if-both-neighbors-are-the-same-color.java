class Solution {
    public boolean winnerOfGame(String colors) {
        ArrayList<Pair<Character, Integer>> list = new ArrayList<>();
        int countA = 0, countB = 0;
        char last = '-';
        for(char ch : colors.toCharArray()) {
            if(ch == 'A') {
                if(countA == 0) {
                    list.add(new Pair('B', countB));
                }
                countA++;
                countB = 0;
            } else {
                if(countB == 0) {
                    list.add(new Pair('A', countA));
                }
                countB++;
                countA = 0;
            }
        }
        if(countA == 0) {
            list.add(new Pair('B', countB));
        }
        if(countB == 0) {
            list.add(new Pair('A', countA));
        }
        int alice = 0, bob = 0;
        
        for(Pair<Character,Integer> p : list) {
            int val = (p.getValue() - 2);
            if(p.getKey().equals('A')) {
                alice += Math.max(0, val);
            } else {
                bob += Math.max(0, val);
            }
        }
        
        // System.out.println(alice + " " + bob);
        
        return alice > bob;
        
    }
}


