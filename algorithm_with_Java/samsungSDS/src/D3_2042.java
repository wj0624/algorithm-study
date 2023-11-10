import java.io.*;
import java.util.*;

public class D3_2042 {
	static int offset;
	static long N, M, K;
	static long[] indexedTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// �Է¹ޱ�
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		for(offset=1;offset<=N;offset*=2);
		//bw.write(String.valueOf(offset));
		
		indexedTree = new long[offset*2+2];
		
		// �ε����� Ʈ���� ������ �Է�
		for(int i=0;i<N;i++) {
			indexedTree[offset+i] = Long.parseLong(br.readLine());
		}
		
		// Ʈ�� ������ �κ� ä���ֱ�
		for(int i=offset-1;i>=1;i--) {
			indexedTree[i] = indexedTree[i*2] + indexedTree[i*2+1];
		}
		
		long psum = 0;
		
		// ��� �Է�
		for(int i=0;i<M+K;i++) {
			String[] cmd = br.readLine().split(" ");
			if(cmd[0].equals("1")) {
				update(Integer.parseInt(cmd[1]), Long.parseLong(cmd[2]));
			}
			else if(cmd[0].equals("2")) {
				psum = sum(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
				sb.append(psum+"\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	//�ε����� Ʈ�� ������Ʈ
	//�Է¹޴� b��°�� ���� �ε����� -1 �ѰͰ� ����. (�ε��� 0���� ����)
	static void update(int id, long value) {
		int xid = offset+id-1;
		//�ش� id�� ������ �� �Է�
		indexedTree[xid] = value;
		while(xid>1) {
			xid/=2;
			indexedTree[xid] = indexedTree[xid*2] + indexedTree[xid*2+1];
		}
		return;
	}
		
	//�ε����� Ʈ�� ������ ���ϱ�
	static long sum(int start, int end) {
		int l = start + offset -1;
		int r = end + offset -1;
		long ret = 0;
		while(l<=r) {
			//(l&1) == 1 equals (l%2) == 1
			if((l&1) == 1) ret += indexedTree[l++];	//���� id�� Ȧ���̸� ���� Ƣ�Ƿ� �����ְ� l++;
			if((r&1) == 0) ret += indexedTree[r--];	//������ id�� ¦���̸� ���� Ƣ�Ƿ� �����ְ� r--;
			l/=2;
			r/=2;
		}
		return ret;
	}	
}
