package com.slidingwindowquestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstringWithoutRepeatingCharacters(String s){

        char [] arr = s.toCharArray();

        // base case
        if(s.length() < 2)
            return s.length();

        //define pointers
        int leftPtr = 0, rightPtr = 0;
        int maxLength = 0;

        //define table
        Map<Character,Integer> map = new HashMap<>();

        while(rightPtr < arr.length){

            map.put(arr[rightPtr],map.getOrDefault(arr[rightPtr],0) + 1);

            /* map.size() =  gives number of keys in map which are usually unique as per definition of map*/
            /* move leftPtr till all elements in array unique */
            while(map.size() != rightPtr - leftPtr + 1){
                  map.put(arr[leftPtr], map.get(arr[leftPtr]) - 1);

                  if( map.get(arr[leftPtr]) == 0)
                      map.remove(arr[leftPtr]);

                  leftPtr++;
            }

            maxLength = Math.max(maxLength, rightPtr - leftPtr + 1 );
            rightPtr++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // abcabcbb
        String str = "abcabcbb";

        int len = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringWithoutRepeatingCharacters(str);
        System.out.printf("Length of Longest Substring Without Repeating Characters in <%s> : %d",str,len);
    }
}
