package org.example.string;

public class StringCompression{

    public String compress(String inputString){
        if (inputString == null || inputString.isBlank()) {
            return inputString;
        }
        int compressedStringLength = countCompressedStringLength(inputString);
        if (compressedStringLength > inputString.length()) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder(compressedStringLength);
        int consecutiveCount = 0;
        for (int i = 0; i < inputString.length(); i++) {
            consecutiveCount++;
            if (i + 1 >= inputString.length() || inputString.charAt(i) != inputString.charAt(i + 1)) {
                sb.append(inputString.charAt(i));
                sb.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return sb.toString();
    }

    private int countCompressedStringLength(String inputString){
        int consecutiveCount = 0;
        int length = 0;
        for (int i = 0; i < inputString.length(); i++) {
            consecutiveCount++;
            if (i + 1 >= inputString.length() || inputString.charAt(i) != inputString.charAt(i + 1)) {
                length += 1 + String.valueOf(consecutiveCount).length();
                consecutiveCount = 0;
            }
        }
        return length;
    }

}
