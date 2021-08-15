package com.mobius.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Num003lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int left = 0,right = 0;
        int length = 0;
        Map<Character,Integer> window = new HashMap<>();

        while(right < s.length()) {
            char r = s.charAt(right);
            window.put(r,window.getOrDefault(r,0) +1);
            right++;
            while(window.get(r) > 1) {
                char l = s.charAt(left);
                left ++;
                window.put(l,window.get(l)-1);
            }

            length = Integer.max(length,right - left);

        }

        return length;
    }
}
