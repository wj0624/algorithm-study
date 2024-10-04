class Solution {
    static boolean[] visited;
    static int n;
    static int[][] computers;
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int cur){
        for(int i=0; i<n; i++){
            if(computers[cur][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}