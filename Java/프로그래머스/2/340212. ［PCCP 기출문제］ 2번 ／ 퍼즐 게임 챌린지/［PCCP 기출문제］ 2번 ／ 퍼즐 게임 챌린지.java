import java.io.*;
import java.util.*;
class Solution {
    static int[] diffs;
    static int[] times;
    static long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int left = 1;
        int right = 100000;
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
       return left;
    }
    
    static boolean isPossible(int level){
        long totalTime = 0;
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i] <= level) totalTime += times[i];
            else {
                int rep = diffs[i] - level;
                totalTime += (times[i] + (i > 0 ? times[i - 1] : 0)) * rep;
                totalTime += times[i];
            }
            if (totalTime > limit) {
                return false;
            }
        }
        return totalTime <= limit;
    }
}