func subsetsWithDup(nums []int) [][]int {
    var ans [][]int
    var curList []int
    bools := make([]bool, len(nums)+1)
    sort.Ints(nums)
    goo(&ans, curList, bools, nums, 0);
    
    return ans;
}

func goo(ans *[][]int, curList []int, bools []bool, nums []int, ind int) {
    
    *ans = append(*ans, append([]int{}, curList...))

    for i := ind; i < len(nums); i++ {
        if i != ind && nums[i] == nums[i - 1]  {
            continue; 
        }
        
        curList = append(curList, nums[i]);
        goo(ans, curList, bools, nums, i + 1);
        curList = curList[:len(curList)-1]
    }
}