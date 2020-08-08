package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class Pallindromic{
    public static void main(String[] args){

      System.out.println(isPallindromic("dog","odh"));
    }

    private static boolean isPallindromic(String first, String second){
        Map<Character, Integer> charset = new HashMap<>();
        if (first == null || second == null) return false;
        if (first.length() != second.length()) return false;
        first=first.toLowerCase();
        second=second.toLowerCase();
        for (int i = 0; i < first.length(); i++) {
            Character fc = first.charAt(i);
            if (!charset.containsKey(fc)) {
                charset.put(fc, 1);
            } else {
                int currentCount = charset.get(fc);
                charset.put(fc, currentCount + 1);
            }
        }

        for (int i = 0; i < second.length(); i++) {
            Character fc = second.charAt(i);
            if (!charset.containsKey(fc)) {
                return false;
            } else {
                int currentCount = charset.get(fc);
                charset.put(fc, currentCount - 1);
            }
        }

        for(Character c:charset.keySet()){
            if(charset.get(c)!=0){
                return false;
            }
        }
        return true;
    }

}
