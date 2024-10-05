import java.util.*;
class Solution {
    static class Word {
        String word;
        int cnt;
        public Word (String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new ArrayDeque<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word cur = q.poll();
            
            // 탈출 조건
            if(cur.word.equals(target)){
                return cur.cnt;
            }
            
            // 다른 글자 수 구하기
            for(int i=0; i<words.length; i++){
                int diff = 0;
                for(int j=0; j<words[i].length(); j++){
                    if(cur.word.charAt(j) != words[i].charAt(j)){
                        diff++;
                    }
                }
                
                if(diff==1 && !visited[i]){
                    visited[i] = true;
                    q.add(new Word(words[i], cur.cnt+1));
                }
            }
        }
        return 0;
    }
}