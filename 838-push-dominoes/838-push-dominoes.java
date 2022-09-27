class Solution {
    public String pushDominoes(String dominoes) {
        char[] domi = dominoes.toCharArray();
        int N= domi.length;
        int[] forces = new int[domi.length];
        
        int force = 0;
        for(int  i= 0; i < domi.length; i++){
            if(domi[i]=='R'){
                force = N;
            }else if(domi[i] == 'L'){
                force = 0;
            }else {
                force = Math.max(force-1, 0);
            }
            forces[i] += force;
        }
        force = 0;
        for(int  i= domi.length-1; i >= 0; i--){
            if(domi[i] == 'L'){
                force = N;
            }else if(domi[i] == 'R'){
                force = 0;
            }else {
                force = Math.max(force-1, 0);
            }
            forces[i] -= force;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : forces){
            if(i < 0){
                sb.append('L');
            }else if(i>0){
                sb.append('R');
            }else{
                sb.append('.');
            }
        }
        
        return sb.toString();
        
        
        
    }
}