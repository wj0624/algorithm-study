import java.io.*;
import java.util.*;

public class practice {
	static int offset, N;
	static long[] indexedTree;
	
	//인덱스드 트리 만들기
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		//1.기준점(N보다 크거나 같은 최소 2의 제곱수) 구하기
		for(offset=1;offset<N;offset*=2);
		
		//2.기준점*2 크기의 배열 생성
		indexedTree = new long[offset*2+2];
		
		//3.주어진 데이터 입력
		for(int i=0;i<N;i++) {
			indexedTree[offset+i] = Long.parseLong(br.readLine());
		}
		
		//4. 구간합 데이터 생성
		for(int i=offset-1;i>=1;i--) {
			indexedTree[i] = indexedTree[i*2] + indexedTree[i*2+1];
		}
	}
	
	//인덱스드 트리 업데이트(
	static void update(int id, long value) {
		int xid = offset+id;
		//해당 id에 수정된 값 입력
		indexedTree[xid] = value;
		while(xid>0) {
			xid/=2;
			indexedTree[xid] = indexedTree[xid*2] + indexedTree[xid*2+1];
		}
		return;
	}
	
	//인덱스드 트리 구간합 구하기
	static long sum(int start, int end) {
		int l = start + offset;
		int r = end + offset;
		long ret = 0;
		while(l<=r) {
			//(l&1) == 1 equals (l%2) == 1
			if((l&1) == 1) ret += indexedTree[l++];	//왼쪽 id가 홀수이면 값이 튀므로 더해주고 l++;
			if((r&1) == 0) ret += indexedTree[r--];	//오른쪽 id가 짝수이면 값이 튀므로 더해주고 r--;
			l/=2;
			r/=2;
		}
		return ret;
	}
	
	
}
