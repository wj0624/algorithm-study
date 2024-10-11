import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. set 생성
        Set<Integer> resSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        
        for(int i: reserve) {
            resSet.add(i);
        }
        for(int i: lost) {
            // 여분이 있는데 도둑 맞았으면 여분 Set에서 제거
            if(resSet.contains(i)) {
                resSet.remove(i);
            }
            else {
                lostSet.add(i);
            }
        }
        
        // 2. 여분 기준으로 앞뒤로 확인하여 체육복 빌려주기
        for(int i: resSet){
            if(lostSet.contains(i-1)){  // 내 앞번호 빌려주기
                lostSet.remove(i-1);
            }
            else if(lostSet.contains(i+1)){ // 내 뒷번호 빌려주기
                lostSet.remove(i+1);
            }
        }
        
        // 3. 전체 학생 수에서 lostSet에 남은 학생 수를 빼주기
        return n-lostSet.size();
    }
}