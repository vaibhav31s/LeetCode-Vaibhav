class Solution {
    public int countOdds(int low, int high) {
  if(low%2 == 0 && high%2 == 0){
            return (high-low)/2;
        }
        return ((high-low)/2) +1;
  
        
    }
    
    
 }
// Brute Force approach
//  int count =0;
//         while(low<high){
//         if(low%2!=0){
//             count++;
//             low+=2;
//         }else{
//             low++;
//         }
//         }
        