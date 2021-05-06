class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        k = nums.length - k;  
        while(start < end) {
            int pIndex = getPivotIndex(nums, start, end);
            if(pIndex < k) start = pIndex + 1;
            else if(pIndex > k) end = pIndex - 1;
            else break;
        }
        return nums[k];
    }
    
    int getPivotIndex(int[] nums, int start, int end) {
        int pivotVal = nums[end]; 
        int pivotIndex = start;
        for(;start < end; start++) {
            if(nums[start] <= pivotVal) swap(nums, start, pivotIndex++);
        }
        swap(nums, pivotIndex, end); 
        return pivotIndex;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
