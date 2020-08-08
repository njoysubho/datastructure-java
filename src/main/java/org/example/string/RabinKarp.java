package org.example.string;

public class RabinKarp{

    public static boolean isMatch(String text,String pattern){
        if(text==null||pattern==null) return false;
        int ph = hash(pattern,pattern.length());
        int m=pattern.length();
        int n= text.length();
        int th = hash(text,m);
        if(ph==th) return true;
        for(int i=m;i<n;i++){
             th = (int) ((th - text.charAt(i-m)*Math.pow(10,m-1))*10+text.charAt(i));
             if(th==ph) return true;
        }
        return false;
    }

    private static int hash(String pattern,int length){
        int hash =0;
        int j =0;
        for(int i=length-1;i>=0;i--){
            hash+=pattern.charAt(j++)*Math.pow(10,i);
        }
        return hash;
    }
}
