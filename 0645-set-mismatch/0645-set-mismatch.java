class Solution {
    public int[] findErrorNums(int[] arr) {
        int[] ar = {-1,-1};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                ar[0] = arr[i];
                ar[1] = i+1;
                return ar;
            }
        }
        return ar;

    }
    void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!= arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
    }
    
    void swap(int[] arr, int start, int end) {
        int temp=  arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}