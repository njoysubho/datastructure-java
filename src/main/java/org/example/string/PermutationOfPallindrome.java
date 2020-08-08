package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfPallindrome{

    public static boolean check(String inputString){
        if(inputString==null||inputString.isEmpty()){
            return false;
        }
        Map<Character, Integer> indexTable = countOccurenceOfletter(inputString);
        boolean foundOdd = false;
        for (Character chars : indexTable.keySet()) {
            int count = indexTable.get(chars);
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return foundOdd;
    }

    private static Map<Character, Integer> countOccurenceOfletter(String inputString){
        char[] chars = inputString.toLowerCase().toCharArray();
        var countMap = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                if (countMap.get(aChar) == null) {
                    countMap.put(aChar, 1);
                } else {
                    int previousCount = countMap.get(aChar);
                    countMap.put(aChar, previousCount + 1);
                }
            }
        }
        return countMap;
    }
}
