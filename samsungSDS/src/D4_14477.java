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
		
		//최대 공약수
		int tmp = 0;
		
		for(int i=0; i<n; i++) {
			//i번째 수 빼기(0으로 update)
			t.update(i, 0);
			//나머지 수들의 최대 공약수가 k의 약수가 아니라면(나머지가 0이 아니라면)
			if(data[i]%t.getRoot()!=0) {
				//현재 최대 공약수가 이전의 최대 공약수보다 크다면
				if(t.getRoot()>tmp) {
					tmp = t.getRoot();
					k = data[i];
				}
			}
			//뺐던 값 다시 tree에 넣기
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
			//인덱스드 트리 생성
			for(offset=1;offset<arr.length;offset*=2);		
			this.tree = new int[offset*2+1];
			
			//인덱스드 트리에 데이터 입력
			for(int i=0;i<arr.length;i++) {
				tree[offset+i] = arr[i];
			}
			
			//부모에 최대 공약수 채워넣기
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
		
		//인덱스드 트리 안에 있는 숫자들의 최대 공약수 반환
		int getRoot() {
			return this.tree[1];
		}
	}

}