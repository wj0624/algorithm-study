package algorithm;
import java.io.*;
import java.util.*;

public class D3_10845 {
	static int N;
	static class myqueue {
		int front,rear;
		int [] queue;
		
		//√ ±‚»≠
		public myqueue(int size) {
			this.front = 0;
			this.rear = 0;
			this.queue = new int [size+1];
		}
		
		public void push(int x) {
			queue[rear] = x;
			rear++;
		}
		
		public int pop() {
			return front==rear ? -1 : queue[front++];
		}
		
		public int size() {
			return rear-front;
		}
		
		public int empty() {
			return front==rear ? 1 : 0;
		}
		
		public int front() {
			return front==rear ? -1 : queue[front];
		}
		
		public int back() {
			return front==rear ? -1 : queue[rear-1];
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		myqueue queue = new myqueue(N); 
		
		for(int i=0; i<N; i++) {
			String[] cmd = br.readLine().split(" ");
			if(cmd[0].equals("push")) queue.push(Integer.parseInt(cmd[1]));
			else if(cmd[0].equals("pop")) sb.append(queue.pop()+"\n");
			else if(cmd[0].equals("size")) sb.append(queue.size()+"\n");
			else if(cmd[0].equals("empty")) sb.append(queue.empty()+"\n");
			else if(cmd[0].equals("front")) sb.append(queue.front()+"\n");
			else if(cmd[0].equals("back")) sb.append(queue.back()+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}