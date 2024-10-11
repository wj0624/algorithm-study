import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        // 1. info 기반 hashmap 만들기
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        for(String i : info){
            String[] data = i.split(" ");
            String[] langs = {data[0], "-"};
            String[] parts = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer score = Integer.parseInt(data[4]);
            for(String lang : langs){
                for(String part : parts){
                    for(String exp : exps){
                        for(String food : foods){
                            String[] keyArr = {lang, part, exp, food};
                            String key = String.join(" ", keyArr);
                            ArrayList<Integer> values = hm.getOrDefault(key, new ArrayList<Integer>());
                            values.add(score);
                            hm.put(key, values);
                        }
                    }
                }
            }
        }
        
        // 2. 각 hashmap value를 정렬
        for(ArrayList<Integer> values : hm.values()){
            Collections.sort(values);
        }
        
        // 3. query 조건에 맞는 지원자 가져오기
        int[] answer = new int[query.length];
        int i = 0;
        for(String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);
            
            if(hm.containsKey(key)){
                ArrayList<Integer> list = hm.get(key);
                // 4. binarySearch 해서 lower bound 찾기서 lower bound 찾기
                int left = 0;
                int right = list.size();
                while(left < right){
                    int mid = (left+right) / 2;
                    if(list.get(mid) >= target){
                        right = mid;
                    }
                    else left = mid + 1;
                }
                answer[i] = list.size() - left;
            }
            i++;
        }
        

        return answer;
    }
}