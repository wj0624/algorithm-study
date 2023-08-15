import java.io.*;
import java.util.*;

public class D4_14477 {
	
	static int n, k;
	static int[] data;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		data = new int[n];
		k = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		itree t = new itree(data);
		
		//�ִ� �����
		int tmp = 0;
		
		for(int i=0; i<n; i++) {
			//i��° �� ����(0���� update)
			t.update(i, 0);
			//������ ������ �ִ� ������� k�� ����� �ƴ϶��(�������� 0�� �ƴ϶��)
			if(data[i]%t.getRoot()!=0) {
				//���� �ִ� ������� ������ �ִ� ��������� ũ�ٸ�
				if(t.getRoot()>tmp) {
					tmp = t.getRoot();
					k = data[i];
				}
			}
			//���� �� �ٽ� tree�� �ֱ�
			t.update(i, data[i]);
		}
		
		if(tmp==0) System.out.println(-1);
		else
			System.out.println(tmp+" "+k);
		br.close();
	}
	
	//getGcd(gcd(gcd(a,b),c),d);
	static int gcd(int x, int y) {
		int r;
		while(y>0) {
			r = x%y;
			x = y;
			y = r;
		}
		return x;
	}
	
	static class itree{
		int offset;
		int [] tree;
		
		public itree(int[] arr) {
			//�ε����� Ʈ�� ����
			for(offset=1;offset<arr.length;offset*=2);		
			this.tree = new int[offset*2+1];
			
			//�ε����� Ʈ���� ������ �Է�
			for(int i=0;i<arr.length;i++) {
				tree[offset+i] = arr[i];
			}
			
			//�θ� �ִ� ����� ä���ֱ�
			for(int i=offset-1;i>0;i--) {
				tree[i] = gcd(tree[i*2], tree[i*2+1]);
			}
		}
		
		void update(int id, int value) {
			int nid = id + offset;
			tree[nid] = value;
			while(nid > 1) {
				nid /= 2;
				tree[nid] = gcd(tree[nid*2], tree[nid*2+1]);
			}
			return;
		}
		
		//�ε����� Ʈ�� �ȿ� �ִ� ���ڵ��� �ִ� ����� ��ȯ
		int getRoot() {
			return this.tree[1];
		}
	}

}