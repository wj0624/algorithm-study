package algorithm;
import java.io.*;
import java.util.*;

public class D3_10828 {
	static int N;
	static class mystack {
		int pt;
		int [] stack;
		
		//√ ±‚»≠
		public mystack(int size) {
			this.pt = 0;
			this.stack = new int [size+1];
		}
		
		public void push(int x) {
			stack[pt] = x;
			pt++;
		}
		
		public int pop() {
			return pt==0 ? -1 : stack[--pt];
		}
		
		public int size() {
			return pt;
		}
		
		public int empty() {
			return pt==0 ? 1 : 0;
		}
		
		public int top() {
			return pt==0 ? -1 : stack[pt-1];
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		mystack stack = new mystack(N); 
		
		for(int i=0; i<N; i++) {
			String[] cmd = br.readLine().split(" ");
			if(cmd[0].equals("push")) stack.push(Integer.parseInt(cmd[1]));
			else if(cmd[0].equals("pop")) sb.append(stack.pop()+"\n");
			else if(cmd[0].equals("size")) sb.append(stack.size()+"\n");
			else if(cmd[0].equals("empty")) sb.append(stack.empty()+"\n");
			else if(cmd[0].equals("top")) sb.append(stack.top()+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}