package org.example.string;

import java.nio.charset.StandardCharsets;

public class StringCompare{
    public static void main(String[] args){

      System.out.println(new String("ä".getBytes(StandardCharsets.US_ASCII)));
    }
/*    static char getChar(byte[] val, int index) {
        index <<= 1;
        return (char)(((val[index++] & 0xff) << HI_BYTE_SHIFT) |
                ((val[index]   & 0xff) << LO_BYTE_SHIFT));
    }*/
}
