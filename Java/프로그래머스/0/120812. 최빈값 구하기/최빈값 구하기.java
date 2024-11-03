import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
            max = Math.max(max, map.get(array[i]));
        }
        
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max) {
                cnt++;
                answer = entry.getKey();
            }
        }
        
        return cnt > 1 ? -1 : answer;
    }
}