class KthLargest {
    ArrayList<Integer> list;
    int k = 0;
    public KthLargest(int k, int[] nums) {
        list = new  ArrayList<>(100001);
        Arrays.sort(nums);
        for(int x : nums) list.add(x);
        this.k = k;
    }
    
    public int add(int val) {
        
        int pos = BinarySearch.bsearchCeil(list, 0, list.size() - 1, val);
        list.add(pos, val);
        // System.out.println(list);
        return list.get(list.size() - k);
    }
}
public class BinarySearch {
          public static int bsearch(int[] a, int lo, int hi, int val) {
            while (lo <= hi) {
              int mid = lo + ((hi - lo) >> 1);
              if (a[mid] == val)
                return mid;
              else if (a[mid] < val)
                lo = mid + 1;
              else
                hi = mid - 1;
            }
            return -1;
          }
        
          public static int bsearchCeil(ArrayList<Integer> a, int lo, int hi, int val) {
            while (lo <= hi) {
              int mid = lo + ((hi - lo) >> 1);
              if (a.get(mid) < val)
                lo = mid + 1;
              else
                hi = mid - 1;
            }
            return lo;
          }
        
          public static int bsearchFloor(int[] a, int lo, int hi, int val) {
            while (lo <= hi) {
              int mid = lo + ((hi - lo) >> 1);
              if (a[mid] <= val)
                lo = mid + 1;
              else
                hi = mid - 1;
            }
            return hi;
          }
        
        
        }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */