package algorithm;
import java.io.*;
import java.util.*;

public class D1_1103{
	
	static int N, M, ans;
	static boolean iFlag; //Infinite Flag ���ѷ����� ������ Ż��
	
	static int[] dy = {0, 0, -1, 1};	//�� �̵�
	static int[] dx = {-1, 1, 0, 0};	//�� �̵�
	
	static int[][] board, score;
	static boolean[][] visit;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		board = new int[N][M];
		score = new int[N][M];
		visit = new boolean[N][M];
		
		//�Է�
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				//int�� ���缭 map�� �־���
				if(str.charAt(j) == 'H') board[i][j] = 10;
				else board[i][j] = str.charAt(j) - 48;
			}
		}
		
		//DFS�� ���� �켱 Ž�� + DP�� ����ġ��
		visit[0][0] = true;	//(0,0) ���� loop Ȯ�ο� true ��ŷ
		iFlag = false;
		dfs(0,0,1); //(0,0)���� ���
		
		if(iFlag) bw.write(String.valueOf(-1));
		else bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();		
	}
	static void dfs(int y, int x, int cnt) {
		if(cnt > ans) ans = cnt; //�� �ֽ�ȭ
		score[y][x] = cnt; //����ġ��� dp�迭�� ���� cnt ��ŷ
		for(int i=0;i<4;i++) {
			int num = board[y][x]; //���忡 ���� ����
			int ny = dy[i] * num + y; //���忡 ���� ����*���� ��ŭ �̵�
			int nx = dx[i] * num + x;
			
			if(ny<0||nx<0||ny>=N||nx>=M||board[ny][nx]==10) continue;	//���� ���� �Ѿ�ų� �����̸� �Ѿ��
			if(visit[ny][nx]) {
				iFlag = true;
				return; //�湮�� ������ ���ƿ����Ƿ� ���� loop����
			}
			if(score[ny][nx] > cnt) continue; //���� �湮Ƚ������ ũ�� ���� x, �ּ� ����Ƚ�� ���ϱ� ����
			visit[ny][nx] = true;
			dfs(ny, nx, cnt+1);
			visit[ny][nx] = false;
		}
	}
}
/*1. Ż������
if(Ż������){
	return;
}
2. ������ ���� �湮
// ������ǥ(�����¿�)
for(��������){
	//2-1. ��ǥ�ʰ� continue
	 int nr = r+dr[i];
	 int nc = c+dc[i];
	 
	 //2-2. dfs ����
	 visit[nr][nc] = true;
	 dfs(nr,nc);
	 visit[nr][nc] = false;
}
*/
