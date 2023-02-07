import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		String []temp = sc.nextLine().split("");
		int cnt = 0;
		
		for (int i=0; i< temp.length;i++) {
			String str = temp[i];
			if (str.equals("(")) {
				stack.push(str);
			}
			else {
				if (temp[i-1].equals("(")) {
					stack.pop();
					cnt += stack.size();
				}else {
					cnt +=1;
					stack.pop();
				}
			}
		}
		System.out.println(cnt);
	}
}