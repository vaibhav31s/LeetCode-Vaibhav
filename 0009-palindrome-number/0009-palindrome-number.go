func isPalindrome(x int) bool {
    if x < 0 {
        return false;
    }
    
    cur := 0;
    
    firstCopy := x;
    
    for {
        if x <= 0 {
            break;
        }
        cur *= 10;
        cur += x % 10;
        x /= 10;
    }
    
    return firstCopy == cur;
}