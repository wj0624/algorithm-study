import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        for(int cnt: map.values()){
            answer *= cnt+1;
        }
        
        return answer-1;
    }
}