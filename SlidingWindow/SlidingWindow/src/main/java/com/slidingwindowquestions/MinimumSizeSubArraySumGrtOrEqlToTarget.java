package com.slidingwindowquestions;

public class MinimumSizeSubArraySumGrtOrEqlToTarget {

    public int minSizeSubarraySumGreaterOrEqualToTarget(int target, int [] nums){

        int leftPtr = 0, rightPtr = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;


        while(rightPtr < nums.length){

            /*Add Element*/
            sum = sum + nums[rightPtr];

            /*If condition is met start contracting the window*/
            while(sum >= target){
                min = Math.min(min,rightPtr - leftPtr + 1);  //(rightPtr - leftPtr + 1) = Number of elements in that window
                sum = sum - nums[leftPtr];
                leftPtr++;
            }
            rightPtr++;
        }
        /*if no min value is found then return zero instead*/
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
/*         int [] numbers = {1,1,1,1,1,1};
           int targetSum = 11;  */

//      int [] numbers = {2,3,1,2,4,7};

        int [] numbers = {2,3,1,2,4,3};
        int targetSum = 7;

        MinimumSizeSubArraySumGrtOrEqlToTarget minSizeSubArrSum = new MinimumSizeSubArraySumGrtOrEqlToTarget();
        int size = minSizeSubArrSum.minSizeSubarraySumGreaterOrEqualToTarget(targetSum,numbers);
        System.out.printf("Minimum Size Subarray Sum Greater than or Equal to target (%d) is : %d",targetSum,size);
    }
}
