import java.io.*;
import java.util.*;

class indexedTree {
	int offset;
	long[] tree;
	
	public indexedTree(int size) {
		//������(N���� ũ�ų� ���� �ּ� 2�� ������) ���ϱ�
		for(offset=1;offset<size;offset*=2);
		//������*2 ũ���� �迭 ����
		tree = new long[offset*2+2];
	}

	public void init(int[] data) {
		
		//������ �ε����� Ʈ���� �Է�
		for(int i=0;i<data.length;i++) {
			tree[offset+i] = data[i];
		}
		
		//������ ������ ����
		for(int i=offset-1;i>0;i--) {
			tree[i] = tree[i*2] + tree[i*2+1];
		}
	}

	public void update(int id, long value) {
		int xid = offset+id;
		//�ش� id�� ������ �� �Է�
		tree[xid] = value;
		while(xid>0) {
			xid/=2;
			tree[xid] = tree[xid*2] + tree[xid*2+1];
		}
		return;
	}
	
	//�ε����� Ʈ�� ������ ���ϱ�
	public int sum(int start, int end) {
		int l = start + offset;
		int r = end + offset;
		int ret = 0;
		while(l<=r) {
			if((l%2) == 1) ret += tree[l++];	//���� id�� Ȧ���̸� ���� Ƣ�Ƿ� �����ְ� l++;
			if((r%2) == 0) ret += tree[r--];	//������ id�� ¦���̸� ���� Ƣ�Ƿ� �����ְ� r--;
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
		
		//�������� ����
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
		
		//�޸��� �Ƿ� �� �������� ����
		Arrays.sort(playerList);
		
		for(int i=0;i<N;i++) {
			player me = playerList[i];
			
			itree.update(me.id, 1);
			
			//���� �迭�� ���� ���� ������ ������� �־�� �Է� ������� ��µ�
			ans[me.id] = itree.sum(0, me.id);
		}
		
		//���
		for(int i=0;i<N;i++) {
			bw.write(String.valueOf(ans[i])+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
