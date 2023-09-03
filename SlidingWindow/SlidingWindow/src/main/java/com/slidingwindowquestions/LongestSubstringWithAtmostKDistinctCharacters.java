package com.slidingwindowquestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters {


    public static int lengthOfLongestSubstringWithKDistinctCharacters(String s, int k){

       int leftPtr = 0, rightPtr = 0;
       int maxLength = 0;

       if(s.length() < k)
           return s.length();

       char [] arr = s.toCharArray();

       Map<Character,Integer> map = new HashMap<>();

       while(rightPtr < arr.length){

           map.put(arr[rightPtr],map.getOrDefault(arr[rightPtr],0) + 1);

           while(map.size() > k){
              map.put(arr[leftPtr],map.get(arr[leftPtr]) - 1);

              if(map.get(arr[leftPtr]) == 0)
                  map.remove(arr[leftPtr]);

              leftPtr++;
           }

           maxLength = Math.max(maxLength,rightPtr - leftPtr + 1);
           rightPtr++;
       }
       return  maxLength;
    }

    public static void main(String[] args) {

        String str = "ccaabbbe";
        int k = 3;

        int len = LongestSubstringWithAtmostKDistinctCharacters.lengthOfLongestSubstringWithKDistinctCharacters(str,k);
        System.out.printf("Length of Longest Substring With Atmost K(%d) Distinct Characters in <%s> : %d",k,str,len);

    }
}
