import java.io.*;
import java.util.*;
public class day10{
	static int N;
	static game[][] board;
	//U, D, R, L
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int gscore;
	static int pscore;
	
	static class game{
		int count;
		char command;
		public game(int count, char command) {
			this.count = count;
			this.command = command;
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new game[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rg = Integer.parseInt(st.nextToken())-1;
		int cg = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		int rp = Integer.parseInt(st.nextToken())-1;
		int cp = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				String tmp = str[j];
				int cnt = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
				char cmd = tmp.charAt(tmp.length()-1);
				board[i][j] = new game(cnt, cmd);
			}
		}
		
		gscore = sol(rg, cg);
		pscore = sol(rp, cp);
		
		if(gscore>pscore) {
			System.out.println("goorm "+gscore);
		}
		else {
			System.out.println("player "+pscore);
		}
		br.close();
	}
	
	
	static int sol(int r, int c) {
		int y = r;
		int x = c;
		int score = 1;
		int[][] visited = new int[N][N];
		visited[y][x] = 1;
		boolean flag = true;
		
		while(flag) {
			game cur = board[y][x];
			for(int i=0; i<cur.count; i++) {
				switch(cur.command) {
				case 'U' :
					y += dr[0];
					x += dc[0];
					break;
				case 'D':
					y += dr[1];
					x += dc[1];
					break;
				case 'R' :
					y += dr[2];
					x += dc[2];
					break;
				case 'L' :
					y += dr[3];
					x += dc[3];
					break;
				}
				if(y<0) {
					y = N-1;
				}
				if(x<0) {
					x = N-1;
				}
				if(y>=N) {
					y = 0;
				}
				if(x>=N) {
					x = 0;
				}
				if(visited[y][x]==0) {
					visited[y][x]=1;
					score += 1;
				}
				else {
					flag = false;
					break;
				}
			}
		}
		return score;
	}
}

