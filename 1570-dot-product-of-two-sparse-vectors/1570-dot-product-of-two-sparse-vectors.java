class SparseVector {
    int[] ans;
    
    SparseVector(int[] nums) {
      ans = nums;
         
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum =0;
        for(int i =0 ; i< ans.length;i++){
            sum += ans[i] * vec.ans[i];
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);