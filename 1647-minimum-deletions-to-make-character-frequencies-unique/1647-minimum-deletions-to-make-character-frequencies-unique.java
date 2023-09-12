class Solution {
    public int minDeletions(String s) {
        int[] map = new int[26];
        for(char ch :  s.toCharArray()) {
            map[ch - 'a']++;
        }
        
        Arrays.sort(map);
        
        reverse(map);
        for(int i = 0; i < 25; i++) {
            // if(map[i] == )
            
            
            while (map[i] <= map[i + 1] && map[i + 1] > 0) {
                map[i + 1]--;
            }
        }
        
        int sum = 0;
        for(int x : map) sum += x;
        
        return s.length() - sum;
    }
    public static void reverse(int[] array)
    {
 
        // Length of the array
        int n = array.length;
 
        // Swapping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {
 
            // Storing the first half elements temporarily
            int temp = array[i];
 
            // Assigning the first half to the last half
            array[i] = array[n - i - 1];
 
            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}

// 2 1 2"bbcebab"
// 4 1 1 1 

    
