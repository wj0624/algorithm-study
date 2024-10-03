import java.io.*;
import java.util.*;
class Solution {
    static int[] video, p, op_s, op_e;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        video = Arrays.stream(video_len.split(":"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        p = Arrays.stream(pos.split(":"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        op_s = Arrays.stream(op_start.split(":"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        op_e = Arrays.stream(op_end.split(":"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        for(String str : commands){
            jump();
            switch(str) {
                case "next" : {
                    p[1] += 10; //10초 후로 이동
                    if(p[1] >= 60){
                        p[0]++;
                        p[1] -= 60;
                    }
                    if (p[0] > video[0] || (p[0] == video[0] && p[1] > video[1])) {
                            p[0] = video[0];
                            p[1] = video[1];
                    }
                    jump();
                    break;
                }
                case "prev" : {
                    p[1] -= 10; //10초 전으로 이동
                    if(p[1] < 0) {
                        p[0]--;
                        p[1] += 60;
                    }
                    if (p[0] < 0){
                        p[0] = 0;
                        p[1] = 0;
                    } 
                    jump();
                    break;
                }
            }
        }
        String answer = String.format("%02d:%02d", p[0], p[1]);
        return answer;
    }
    
    static void jump(){
        int current = p[0] * 60 + p[1];
        int opStart = op_s[0] * 60 + op_s[1];
        int opEnd = op_e[0] * 60 + op_e[1];
        if(current >= opStart && current <= opEnd){
            p[0] = op_e[0];
            p[1] = op_e[1];
        }
    }
}