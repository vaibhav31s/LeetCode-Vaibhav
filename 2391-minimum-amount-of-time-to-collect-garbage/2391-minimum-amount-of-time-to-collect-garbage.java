class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] pref = new int[travel.length + 1];
        pref[1] = travel[0];
        
        for(int i = 1; i < travel.length; i++) {
            pref[i + 1] =  travel[i];
        }
        // System.out.println(Arrays.toString(pref));
        int answer = 0;
        int paper = 0;
        int metal = 0;
        int glass =0;
        for (int i = 0;i < Math.min(garbage.length, maxMPG(garbage, "P") + 1); i++) {
            answer += (go(garbage[i], 'P') + pref[i]);
        }
        
        
        for (int i = 0;i < Math.min(garbage.length, maxMPG(garbage, "M") + 1); i++) {
            answer += (go(garbage[i], 'M') + pref[i]);
        }
        
        for (int i = 0;i < Math.min(garbage.length, maxMPG(garbage, "G") + 1); i++) {
            answer += (go(garbage[i], 'G') + pref[i]);
        }
        
        // System.out.println(metal + " " + " " + glass + " " + paper);
        
        return answer;
    }
    int maxMPG(String[] garbage, String ch) {
        
        for(int i = garbage.length-1; i >= 0; i--) {
            if(garbage[i].contains(ch)) return i;
        }
    return 0 ;
    }
    
    int go(String s, char ch) {
        int a = 0;
        for(char c : s.toCharArray()) if(c == ch) a++;
        return a;
    }
    
             
}