import java.io.*;
import java.util.*;
class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(String str : operations){
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(cmd.equals("I")) {
                maxQ.add(num);
                minQ.add(num);
            }
            else if(cmd.equals("D")){
                if(num == 1){
                    minQ.remove(maxQ.poll());
                }
                else if(num == -1){
                    maxQ.remove(minQ.poll());
                }
            }
        }
        if(maxQ.isEmpty() || minQ.isEmpty()){
            return new int[]{0, 0};
        }
        answer[0] = maxQ.poll();
        answer[1] = minQ.poll();
        return answer;
    }
}