import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] building = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력

		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			while (stack.size() != 0) { // 만약 더 높으면 
				if (arr[stack.peek()] >= arr[i]) {
					building[i] = stack.peek(); // 그 건물의 인덱스를 저장한다.
					break;
				} else {
					stack.pop(); // 자신보다 높은것을 만날때 까지 계속 pop
				}
			}
			stack.push(i); // 스택에 인덱스를 집어넣는다.
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(building[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}