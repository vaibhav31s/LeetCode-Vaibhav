class Solution {
    public String validIPAddress(String queryIP) {
        
        if (isIPv4(queryIP)) {
            return "IPv4";
        } else if (isIPv6(queryIP)) {
            return "IPv6";
        } 
        
        return "Neither";
    }
    
    boolean isIPv4(String s) {
        String[] ip = s.split("\\.");
        int countDot = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '.') countDot++;
        }
        if (countDot != 3) return false;
        System.out.println(Arrays.toString(ip));
        if (ip.length == 4) {
            for (String xi : ip) {
                int val;
                try {
                    val = Integer.parseInt(xi);
                } catch (Exception e) { 
                    return false;
                }
                if (val == 0 && xi.length() > 1) {
                    return false;
                }
                
                if (val < 0 || val > 255) {
                    return false;
                }
                
                if (xi.charAt(0) == '0' && val != 0) return false;
                
                
            }
            
            return true;
        } else {
            return false;
        }
    }
    
    boolean isIPv6(String s) {
        String[] ip = s.split("\\:");
        System.out.println(Arrays.toString(ip));
        
        int countDot = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ':') countDot++;
        }
        if (countDot != 7) return false;

        if (ip.length == 8) {
            for (String xi : ip) {
                
                if (xi.length() > 4 || xi.length() == 0) {
                    return false;
                }
                
                for (char ch : xi.toCharArray()) {
                    if (ch >= '0' && ch <= '9') {
                        
                    } else if (ch >= 'a' && ch <= 'f') {
                        
                    } else if (ch >= 'A' && ch <= 'F') {
                        
                    } else {
                        return false;
                    }
                }
            }
            return true;
            
        } else {
            return false;
        }
    }
    
}