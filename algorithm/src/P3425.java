import java.io.*;
import java.util.*;

public class P3425{
	
	StringBuilder sb = new StringBuilder();
	static boolean Qflag = false;
	
	static class goStack{
		static ArrayList<Integer> stack = new ArrayList<>();
		static int pt = 0;
		
		public goStack() {
			this.stack = stack;
			this.pt = pt;
		}

		static void num(int x) {
			stack.add(pt, x);
			pt++;
		}
		
		static void pop() {
			stack.remove(pt);
			pt--;
		}
		
		static void inv() {
			stack.set(pt, -(stack.get(pt)));
		}
		
		static void dup() {
			if(pt>0) {
				stack.add(pt+1, stack.get(pt));
				pt++;
			}
		}
		
		static void swp() {
			int tmp = stack.get(pt);
			stack.set(pt, stack.get(pt-1));
			stack.set(pt-1, tmp);
		}
		
		static void add() {
			if(pt>1) {
				stack.set(pt-1, stack.get(pt)+stack.get(pt-1));
				pt--;
			}
		}
		
		static void sub() {
			stack.set(pt-1, stack.get(pt-1)-stack.get(pt));
			pt--;
		}
		
		static void mul() {
			stack.set(pt-1, stack.get(pt-1)*stack.get(pt));
			pt--;
		}
		
		static void div() {
			if(stack.get(pt-1)<0) {
				if(stack.get(pt)<0) stack.set(pt-1, Math.abs(stack.get(pt-1))/Math.abs(stack.get(pt)));
				else stack.set(pt-1, Math.abs(stack.get(pt-1))/stack.get(pt));
			}
			else stack.set(pt-1, stack.get(pt-1)/stack.get(pt));
			pt--;
		}
		static void mod() {
			if(stack.get(pt-1)<0) {
				if(stack.get(pt)<0) stack.set(pt-1, Math.abs(stack.get(pt-1))%Math.abs(stack.get(pt)));
				else stack.set(pt-1, Math.abs(stack.get(pt-1))%stack.get(pt));
			}
			else stack.set(pt-1, stack.get(pt-1)%stack.get(pt));
			pt--;
		}
		
		static void end() {
			stack = new ArrayList<>();
			pt = 0;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if(cmd.equals("QUIT")) {
				Qflag = true;
				break;
			}
			
			
			
		}
		
	}
}
