package algorithm;
import java.io.*;
import java.util.*;

// ��ġ class
class location{
	int y, x;
	// Alt + Shift + s
	public location(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}

public class D1_3055 {
	
	private static final String FAIL = "KAKTUS";
	
	static int R, C;
	static int time;
	
	//up, down, left, right
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	
	static char [][] map;
	static char [][] visit;
	
	static Queue<location> water; //�� ��ġ
	static Queue<location> loc; //����ġ ��ġ
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //���� ���� ����
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		map = new char[R][C];
		visit = new char[R][C];
		
		String str; //input�� �ӽú���
		
		loc = new LinkedList<location>();
		water = new LinkedList<location>();
		
		
		for(int i=0; i<R; i++) {
			str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					visit[i][j] = 'x'; //���� �ִ� ���� �湮�� �� �����Ƿ� x ó��
					water.offer(new location(i, j)); //���� ��ġ ť�� �ֱ�
				}
				else if(map[i][j] == 'D') visit[i][j] = 'g';
				else if(map[i][j] == 'X') visit[i][j] = 'x';
				else if(map[i][j] == '.') visit[i][j] = 'p';
				else {//map[i][j] == 'S'
					//����ġ ���� ��ġ�� �̵�. ȫ���� ���� ��ĭ ó��
					map[i][j] = '.';
					visit[i][j] = 'x';
					loc.offer(new location(i,j)); //����ġ ��ġ ť�� �ֱ�
				}
			}
		}
		bfs();
		if(time==-1) bw.write(FAIL);
		else bw.write(String.valueOf(time));
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(){
		for(time=1; ;time++) {
		
			//1) �� BFS
			int wSize = water.size();
			for (int i=0; i<wSize; i++) {
				location cur = water.poll(); //ť ����
				
				//�������
				for(int j=0;j<=3;j++) {
					int nr = cur.y + dr[j];
					int nc = cur.x + dc[j];
					
					//���� ���� �ʰ���
					if(nr<0||nc<0||nr>=R||nc>=C) continue;
					
					if(map[nr][nc]=='.') {
						map[nr][nc] = '*';
						water.offer(new location(nr,nc));
					}
				}
			}
				
			//2) ����ġ BFS
			int lSize = loc.size();
			if(lSize==0) {
				time = -1;
				return;
			}
			for(int i=0; i<lSize; i++) {
				location cur = loc.poll(); //ť ����
				
				//�������
				for(int j=0;j<=3;j++) {
					int nr = cur.y + dr[j];
					int nc = cur.x + dc[j];
					
					//���� ���� �ʰ���
					if(nr<0||nc<0||nr>=R||nc>=C) continue;
					
					if(map[nr][nc]=='D') return;
					if(map[nr][nc]=='.' && visit[nr][nc] == 'p') {
						visit[nr][nc] = 'x';
						loc.offer(new location(nr,nc));
					}
				}
			}
		}
	}
}
/*
1.��ǥ Ŭ���� �����
2.����
 (1)���� ���� Queue�� �ִ´�
 (2)Queue�� ��������
  While(!queue.isEmpty()){

*/