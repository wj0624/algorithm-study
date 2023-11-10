import java.io.*;
import java.util.*;

class indexedTree {
	int offset;
	long[] tree;
	
	public indexedTree(int size) {
		//기준점(N보다 크거나 같은 최소 2의 제곱수) 구하기
		for(offset=1;offset<size;offset*=2);
		//기준점*2 크기의 배열 생성
		tree = new long[offset*2+2];
	}

	public void init(int[] data) {
		
		//데이터 인덱스드 트리에 입력
		for(int i=0;i<data.length;i++) {
			tree[offset+i] = data[i];
		}
		
		//구간합 데이터 생성
		for(int i=offset-1;i>0;i--) {
			tree[i] = tree[i*2] + tree[i*2+1];
		}
	}

	public void update(int id, long value) {
		int xid = offset+id;
		//해당 id에 수정된 값 입력
		tree[xid] = value;
		while(xid>0) {
			xid/=2;
			tree[xid] = tree[xid*2] + tree[xid*2+1];
		}
		return;
	}
	
	//인덱스드 트리 구간합 구하기
	public int sum(int start, int end) {
		int l = start + offset;
		int r = end + offset;
		int ret = 0;
		while(l<=r) {
			if((l%2) == 1) ret += tree[l++];	//왼쪽 id가 홀수이면 값이 튀므로 더해주고 l++;
			if((r%2) == 0) ret += tree[r--];	//오른쪽 id가 짝수이면 값이 튀므로 더해주고 r--;
			l/=2;
			r/=2;
		}
		return ret;
	}
}

public class D3_2517 {
	
	static class player implements Comparable<player>{
		int id, speed;

		public player(int id, int speed) {
			this.id = id;
			this.speed = speed;
		}
		
		//내림차순 정렬
		@Override
		public int compareTo(player o) {
			return o.speed - this.speed;
		}
	}
	
	static int N;
	static player[] playerList;
	static int[] ans;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		playerList = new player[N];
		ans = new int[N];
		
		indexedTree itree = new indexedTree(N);
		
		for(int i=0;i<N;i++) {
			playerList[i] = new player(i, Integer.parseInt(br.readLine()));
		}
		
		//달리기 실력 순 내림차순 정렬
		Arrays.sort(playerList);
		
		for(int i=0;i<N;i++) {
			player me = playerList[i];
			
			itree.update(me.id, 1);
			
			//정답 배열에 넣을 때는 원래의 순서대로 넣어야 입력 순서대로 출력됨
			ans[me.id] = itree.sum(0, me.id);
		}
		
		//출력
		for(int i=0;i<N;i++) {
			bw.write(String.valueOf(ans[i])+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
