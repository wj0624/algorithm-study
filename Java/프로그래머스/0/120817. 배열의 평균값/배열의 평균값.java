import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int n : numbers){
            answer += n;
        }
        answer /= numbers.length;
        return answer;
    }
}