package com.slidingwindowquestions;

public class FindMaxConsecutiveOnesIfAtmostOneZeroFlipAllowed {

    public static int countOfgMaxConsecutiveOnesIfAtmostOneZeroFlipAllowed(int [] arr){

        int leftPtr = 0, rightPtr = 0;
        int countZeros = 0;
        int maxConsecutiveOnes = 0;

        while(rightPtr < arr.length){

            if(arr[rightPtr] == 0)
                countZeros++;

            while(countZeros > 1){

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

        int[] arr = {1,1,0,1,1,1,1,0};

        int len = FindMaxConsecutiveOnesIfAtmostOneZeroFlipAllowed.countOfgMaxConsecutiveOnesIfAtmostOneZeroFlipAllowed(arr);
        System.out.printf("Length of maximum consecutive ones if one zero flip is allowed : %d",len);

    }
}
