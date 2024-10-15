import java.io.*;
import java.util.*;
class Solution {
    static class Truck{
        int weight, remainLen;
        public Truck(int weight, int remainLen){
            this.weight = weight;
            this.remainLen = remainLen;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curSum = 0;
    
        List<Truck> list = new ArrayList<>();
        for(int w: truck_weights){
            while(curSum + w > weight) {
                for(int i=list.size()-1; i>=0; i--){
                    Truck t = list.get(i);
                    t.remainLen--;
                    if(t.remainLen == 0){
                        curSum -= t.weight;
                        list.remove(t);
                    }
                }
                answer++;
            }
            
            list.add(new Truck(w, bridge_length));
            for(int i=list.size()-1; i>=0; i--){
                    Truck t = list.get(i);
                    t.remainLen--;
                    if(t.remainLen == 0){
                        curSum -= t.weight;
                        list.remove(t);
                    }
            }
            curSum += w;
            answer++;
            
        }
        
        answer += list.get(list.size()-1).remainLen + 1;
        return answer;
    }
}