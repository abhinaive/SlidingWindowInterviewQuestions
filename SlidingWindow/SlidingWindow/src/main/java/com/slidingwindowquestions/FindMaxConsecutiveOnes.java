package com.slidingwindowquestions;

import java.util.Map;

public class FindMaxConsecutiveOnes {

    public static int findCountOfMaxConsecutiveOnes(int [] arr){

        int counter = 0;
        int maxConsecutiveOnes = 0;

        for(int element : arr){

            if(element == 0)
                counter = 0;
            else {
                counter++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes,counter);
            }

        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {

        int arr [] = {1,1,0,1,1,1,1,0};

        int len = FindMaxConsecutiveOnes.findCountOfMaxConsecutiveOnes(arr);
        System.out.printf("Length of maximum consecutive ones in arr is : %d",len);


    }
}
