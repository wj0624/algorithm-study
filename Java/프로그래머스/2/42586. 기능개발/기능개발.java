import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        // 각 작업에 걸리는 일수 q에 추가
        for(int i=0; i<progresses.length; i++){
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.add(days);
        }
        
        while(!q.isEmpty()){
            int deployDay = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && q.peek() <= deployDay){
                q.poll();
                cnt++;
            }
            
            list.add(cnt);
        }
 
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}