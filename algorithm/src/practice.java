import java.io.*;
import java.util.*;

public class practice {
	static int offset, N;
	static long[] indexedTree;
	
	//�ε����� Ʈ�� �����
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		//1.������(N���� ũ�ų� ���� �ּ� 2�� ������) ���ϱ�
		for(offset=1;offset<N;offset*=2);
		
		//2.������*2 ũ���� �迭 ����
		indexedTree = new long[offset*2+2];
		
		//3.�־��� ������ �Է�
		for(int i=0;i<N;i++) {
			indexedTree[offset+i] = Long.parseLong(br.readLine());
		}
		
		//4. ������ ������ ����
		for(int i=offset-1;i>=1;i--) {
			indexedTree[i] = indexedTree[i*2] + indexedTree[i*2+1];
		}
	}
	
	//�ε����� Ʈ�� ������Ʈ(
	static void update(int id, long value) {
		int xid = offset+id;
		//�ش� id�� ������ �� �Է�
		indexedTree[xid] = value;
		while(xid>0) {
			xid/=2;
			indexedTree[xid] = indexedTree[xid*2] + indexedTree[xid*2+1];
		}
		return;
	}
	
	//�ε����� Ʈ�� ������ ���ϱ�
	static long sum(int start, int end) {
		int l = start + offset;
		int r = end + offset;
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
