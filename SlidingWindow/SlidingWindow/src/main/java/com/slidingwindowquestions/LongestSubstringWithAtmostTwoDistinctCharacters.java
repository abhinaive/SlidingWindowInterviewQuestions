package com.slidingwindowquestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctCharacters {

    public static int findLenOfLongestSubstringWithAtmostTwoDistinctCharacters(String s){

        /* base case : if string is empty or string have only one character ie. str.length() < 3*/
        char [] arr = s.toCharArray();
        if(arr.length < 3)
            return arr.length;

        int leftPtr = 0, rightPtr = 0;
        int maxLength = 0;
        /*define table */
        Map<Character,Integer> hashMap = new HashMap<>();

        /*find the max length substring with 2 distinct char */
        while(rightPtr < arr.length){

            /* Put incoming character at right ptr in hashmap */
            /*Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.*/
            hashMap.put(arr[rightPtr], hashMap.getOrDefault(arr[rightPtr],0) + 1);

            /* To always maintain exactly 2 distinct characters in map all the time */
            while(hashMap.size() > 2){
                hashMap.put(arr[leftPtr], hashMap.get(arr[leftPtr]) - 1);

                /* remove the entry ie. key also if count of that letter becomes 0 */
                if(hashMap.get(arr[leftPtr]) == 0)
                    hashMap.remove(arr[leftPtr]);

                leftPtr++;

            }
            maxLength = Math.max(maxLength,rightPtr - leftPtr + 1);
            rightPtr++;
        }

        return maxLength;

    }

    public static void main(String[] args) {
        //eceba ccaabbb
        String str = "ccaabbb";

        int len = LongestSubstringWithAtmostTwoDistinctCharacters.findLenOfLongestSubstringWithAtmostTwoDistinctCharacters(str);
        System.out.printf("Length of Longest Substring With Atmost Two Distinct Characters in <%s> : %d",str,len);



    }
}
