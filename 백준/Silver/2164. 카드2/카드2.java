import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		int cnt = 1;  
		while (true) {  // 1->1  2->2 3->2 4->4 5->2 6->4 7->6 8->8 9->2 10->4 11->6 12->8
			cnt *=2;
			if(cnt>=N) {
				cnt = cnt/2;
				break;
			}
		}
		System.out.println((N-cnt)*2);
		
//		Queue<Integer> q = new LinkedList<Integer>();
//		for (int i=1; i<=N; i++) {
//			q.add(i);
//		}
//		while(q.size()!=1) {
//			q.remove();
//			q.add(q.poll());
//		}
//	System.out.println(q.poll());
	}
}