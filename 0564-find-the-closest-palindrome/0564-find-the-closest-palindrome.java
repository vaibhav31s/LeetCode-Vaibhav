class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        List<Long> list = new ArrayList<>(); 
        
        if (len == 1) return String.valueOf(num - 1);

        // - 1 and + 1
        if (isPali(String.valueOf(num - 1))) {
            return String.valueOf(num - 1);
        }
        
        if (isPali(String.valueOf(num + 1))) {
            return String.valueOf(num + 1);
        }
        
        
        // n - 3 n - 2  ----  n + 2 n + 3
        
        
        if (isPali(String.valueOf(num - 2))) {
            list.add(num - 2);
        }
        
        if (isPali(String.valueOf(num + 2))) {
            list.add(num + 2);
        }
        
        if (isPali(String.valueOf(num - 3))) {
            list.add(num - 2);
        }
        
        if (isPali(String.valueOf(num + 3))) {
            list.add(num + 3);
        }
        
        // partition in halve and make the right part palindrome
        // odd
        
        if (len % 2 == 1) {
            long nn = Long.parseLong(n.substring(0, len / 2 + 1)) - 1;
            
            list.add(Long.parseLong(String.valueOf(nn) + reverse(String.valueOf(nn).substring(0, len / 2))));
            
            nn = Long.parseLong(n.substring(0, len / 2 + 1)) + 1;
            
            list.add(Long.parseLong(String.valueOf(nn) + reverse(String.valueOf(nn).substring(0, len / 2))));
            
            
            list.add(Long.parseLong(n.substring(0, len / 2 + 1) + reverse(n.substring(0, len / 2))));
            list.add(Long.parseLong(n.substring(0, len / 2 + 1) + reverse(n.substring(0, len / 2))));
            list.add(Long.parseLong(reverse(n.substring(len / 2)).substring(1) + n.substring(len / 2)));
        }
        
        //even
        if (len % 2 == 0) {
            
            long nn = Long.parseLong(n.substring(0, len / 2)) - 1;
            list.add(Long.parseLong(String.valueOf(nn) + reverse(String.valueOf(nn))));
            
            nn = Long.parseLong(n.substring(0, len / 2)) + 1;
            list.add(Long.parseLong(String.valueOf(nn) + reverse(String.valueOf(nn))));
            
            list.add(Long.parseLong(n.substring(0, len / 2) + reverse(n.substring(0, len / 2))));
            list.add(Long.parseLong(reverse(n.substring(len / 2)) + n.substring(len / 2)));
        }
        
    
        Collections.sort(list);
        // len ka 1000000 and 10000 - 1 nad 10000 + 1;
        
        long cur = 1;
        for (int i = 0; i < len; i++) cur *= 10;
        
        list.add(cur - 1);
        list.add(cur + 1);
        
        long min = Long.MAX_VALUE;
        for (long x : list) {
            if (Math.abs(x - num) != 0)
             min = Math.min(min, Math.abs(x - num));
        }
        System.out.println(list);
        
        for (long x : list) {
            long dif = Math.abs(x - num);
            if (dif == min) return String.valueOf(x);
        }
        
        
        return "";
        
        
    }
    
    boolean isPali(String n) {
        int start = 0, end = n.length() - 1;
        
        while (start <= end) {
            if (n.charAt(start) != n.charAt(end)) return false;
            
            start++;
            end--;
        }
        
        return true;
    }
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}