class Solution {
    static int answer = 0;
    static int [] numbers;
    static int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }
    
    static void dfs(int cur, int total){
        if(cur == numbers.length){
            if(total == target){
                answer++;
            }
            return;
        }
        
        dfs(cur+1, total+numbers[cur]);
        dfs(cur+1, total-numbers[cur]);
    }
}