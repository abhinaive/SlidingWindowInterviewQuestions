package com.slidingwindowquestions;

public class FindMaxConsecutiveOnesIfAtmostKZeroFlipAllowed {

    public static int countOfgMaxConsecutiveOnesIfAtmostKZeroFlipAllowed(int [] arr, int k){

        int leftPtr = 0, rightPtr = 0;
        int countZeros = 0;
        int maxConsecutiveOnes = 0;

        while(rightPtr < arr.length){

            if(arr[rightPtr] == 0)
                countZeros++;

            while(countZeros > k){

                if(arr[leftPtr] == 0)
                    countZeros--;

                leftPtr++;
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes,rightPtr - leftPtr + 1);
            rightPtr++;
        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {

    //  int[] arr = {1,1,0,1,1,1,0,1,0,1,1,1};    //9
        int[] arr = {1,0,0,0,1,1,1};              // 5
        int k = 2;

        int len = FindMaxConsecutiveOnesIfAtmostKZeroFlipAllowed.countOfgMaxConsecutiveOnesIfAtmostKZeroFlipAllowed(arr,k);
        System.out.printf("Length of maximum consecutive ones if k(%d) zero flip is allowed : %d",k,len);

    }
}
