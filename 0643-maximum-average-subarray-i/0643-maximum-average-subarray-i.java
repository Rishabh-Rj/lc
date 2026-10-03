class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum=0;
        int windowSum=0;
        int n = nums.length;

        for(int i =0;i<k;i++){
            windowSum+=nums[i];
        }
        maxSum=windowSum;

        for(int i=k; i<n;i++ ){
            windowSum = windowSum - nums[i-k]+ nums[i];
            if(windowSum>maxSum){
                maxSum= windowSum;
            }
        }

        return (double)maxSum/k;
        
    }
}