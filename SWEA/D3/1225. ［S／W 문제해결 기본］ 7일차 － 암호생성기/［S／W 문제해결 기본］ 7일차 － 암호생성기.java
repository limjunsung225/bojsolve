import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		for(int tc=0; tc<10; tc++) {
			int min_arr = Integer.MAX_VALUE;
			int N = sc.nextInt();
			int [] arr = new int[8];
			Queue<Integer> q = new LinkedList<Integer>();

			for(int i=0;i<8;i++) {// arr에 숫자를 전부 넣고, arr중에서 최소값을 min_arr에 저장한다.
				int num = sc.nextInt();
				arr[i] = num;
				if (num<=min_arr) min_arr=num;
			} 
			
			  // min_q를 15로 나눈만큼 몫 만큼 나머지 q에서도 전부 빼줘도 싸이클은 동일하다. 
			int divide_num = (((min_arr/15)-1)*15); //
			
			for(int i=0; i<8;i++) {
				q.add(arr[i]-divide_num);
			}
			
			int cnt = 1;
			while(true) {
				if (q.peek() -cnt <=0) {
					q.remove(); 
					q.add(0); 
					break;
				}
				
				q.add(q.poll()-cnt);
				cnt += 1;
				if (cnt>5)cnt=1;
			}	
			System.out.printf("#%d ",tc+1);
			for (int i:q) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}