import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] num_arr = { 2, 3, 5, 7 };
	static int N;

	static boolean isPrime(int n) { 
		if (n == 1 || n == 0) 
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) { // 제곱으로 계산해야 하는 횟수를 줄인다. 
			if (n % i == 0) // 나누어 떨어지면 소수가 아니다.
				return false;
		}
		return true;
	}

	static void start(int first, int cnt) { 
		if (cnt == 0)
			System.out.println(first);
		for (int i = 1; i < 10; i += 2) { // 두번 째 수 부터는 홀수만 올 수 있음 
			int tmp = first * 10 + i; // 10을 곱하고  다시 더해주고... 반복하며 소수일때만 다음으로 진행
			if (isPrime(tmp))
				start(tmp, cnt - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < 4; i++) { // 2 ,3 ,5, 7로 시작할 수 있다.
			start(num_arr[i], N - 1);
		}
	}

}