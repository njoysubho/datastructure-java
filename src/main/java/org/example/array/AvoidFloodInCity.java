package org.example.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvoidFloodInCity{
    public static void main(String[] args){
        var rains = new int[]{69,0,0,0,69};
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }

    public static int[] avoidFlood(int[] rains){
        int[] ans = new int[rains.length];
        var fullLakes = new HashSet<Integer>(rains.length);
        var flooded=false;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                var nextToBeRainedLake = findFirstFulllake(rains, i+1, fullLakes);
                if (nextToBeRainedLake == -1) {
                    //theres no full lake
                    ans[i]=1;
                    continue;
                }
                fullLakes.remove(nextToBeRainedLake);
                ans[i] = nextToBeRainedLake;
            } else if (rains[i] > 0 && !fullLakes.contains(rains[i])) {
                fullLakes.add(rains[i]);
                ans[i] = -1;
            }else{
                flooded=true;
                break;
            }
        }
        if (flooded) {
            return new int[0];
        }
        return ans;
    }

    private static int findFirstFulllake(int[] rains, int i, Set<Integer> fullLakes){
        for (int j = i; j < rains.length; j++) {
            if (fullLakes.contains(rains[j])) {
                return rains[j];
            }
        }
        return -1;
    }
}
