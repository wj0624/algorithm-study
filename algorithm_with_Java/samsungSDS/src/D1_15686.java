import java.io.*;
import java.util.*;

public class D1_15686 {
	
	static class loc{
		int r, c;
		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, ans;
	static int[] dist;
	
	static int[][] map; //��� ��
	
	static ArrayList<loc> house;	//���� ��ġ
	static ArrayList<loc> chicken;	//ġŲ�� ��ġ
	
	static boolean isComplete;
	private static final int INF = 999999999; //�ּ� ���� ���簡 �ִ��
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N][N];
		dist = new int[13];
		house = new ArrayList<loc>();
		chicken = new ArrayList<loc>();
	
		ans = 0;
		
		//0�� �� ĭ, 1�� ��, 2�� ġŲ��
		//�Է�
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j]==1) house.add(new loc(i,j));
				else if(map[i][j]==2) chicken.add(new loc(i,j));						
			}
		}
		ans = INF;
		dfs(0, chicken.size()-M);
		
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();
		return;
	}
	
	//���� L��° ġŲ��
	//����ؾ��ϴ� ġŲ�� ���� rest
	static void dfs(int L, int rest) {
		//Ż�� ����
		if(rest == 0) {
			int ret = getDist();
			ans = ret < ans ? ret : ans;
			return;
		}
		if(L > chicken.size()-1) return;
		
		int backup = chicken.get(L).r;
		//1.��� ó�� (y��ǥ�� -1)
		chicken.get(L).r = -1;
		dfs(L+1, rest-1);
		chicken.get(L).r = backup;	//�ٽ� ��Ȱ(backtracking)
		
		//2.������� �ʰ� �Ѿ��
		dfs(L+1, rest);
		return;
		
		
		
	}
	//ġŲ �Ÿ� ���ϱ�
	static int getDist() {
		int tmp;
		int minChick;
		int sum = 0;
		for(int i=0; i<house.size();i++) {
			minChick = INF;
			loc curHouse = house.get(i);
			for(int j=0; j<chicken.size();j++) {
				loc curChick = chicken.get(j);
				//����� ġŲ�� pass
				if(curChick.r==-1) continue;
				
				tmp = Math.abs(curHouse.r-curChick.r)+Math.abs(curHouse.c-curChick.c);
				
				if(tmp < minChick) minChick =tmp;
			}
			sum += minChick;
		}
		return sum;
	}
}
/*
 1.�Է�
 2.M�� ���� ��� ���Ѻ���
  - ����� �Ϸ�� ��Ȳ���� ġŲ �Ÿ��� ������ **���� method
 3.���
 */
