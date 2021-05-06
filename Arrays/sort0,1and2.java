class Solution {
    private int lo = 0;
    public void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
    
    private void color(int[] nums, int c1){
        int hi = nums.length - 1;
        while(lo <= hi){
            if(nums[lo] == c1) lo++;
            else if(nums[hi] != c1) hi--;
            else swap(nums, lo, hi);
        }
    }
    public void sortColors(int[] nums) {
        color(nums, 0);
        color(nums, 1);
    }
}
