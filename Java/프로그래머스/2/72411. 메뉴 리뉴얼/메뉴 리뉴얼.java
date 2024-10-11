import java.io.*;
import java.util.*;
class Solution {
    List<String> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        // 1. 각 order 정렬
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        // 2. 각 order를 기준으로 courseLength만큼의 조합 만들기
        for(int courseLength : course){
            for(String order : orders) {
                combi("", order, courseLength);
            }
            
            // 3. 가장 많은 조합을 answer에 저장
            if(!map.isEmpty()){
                // 맵의 value(즉, 주문수) list
                List<Integer> cntList = new ArrayList<>(map.values());
                // 최대값 구하기
                int max = Collections.max(cntList);
                // 2번 이상 주문 됐다면
                if(max > 1) {
                    for(String key : map.keySet()){
                        if(map.get(key)==max){
                            ans.add(key);
                        }
                    }
                }
                map.clear();    // 맵 초기화
            }
        }
        
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    public void combi(String order, String others, int cnt) {
        // 탈출 조건
        if(cnt==0){
            map.put(order, map.getOrDefault(order, 0)+1);
        }
        // 수행 동작 : 0부터 length까지 조합
        for(int i=0; i<others.length(); i++){
            combi(order+others.charAt(i), others.substring(i+1), cnt-1);
        }
    }
}