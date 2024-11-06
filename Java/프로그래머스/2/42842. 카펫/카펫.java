class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        int s = 3;
        int e = total / 3;
        
        for(int i=s; i<=e; i++){
            for(int j=s; j<=e; j++){
                if(i*j==total && (i-2)*(j-2)==yellow && i>=j) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}