import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        
        for(int c : citations){
            if(c >= answer) break;
            else answer -= 1;
        }
        return answer;
    }
}