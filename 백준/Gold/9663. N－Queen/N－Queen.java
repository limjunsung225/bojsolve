import java.util.Scanner;

public class Main {
	
	static int N, col[], answer;
	
	private static void setQueen(int rowNo) { // rowNo : 놓으려고 하는 퀸의 행 번호
		
		// 가지 치기를 위해서 유망성 검사
		// ==> 재귀를 타고 올 때 유망성을 검사하지 않고 보냈기 때문에 이전 row가 유망한지
		// 검사해서 유망하지 않으면 back
		if(!isAvailable(rowNo-1)) return; 
		
		//기저조건
		if(rowNo>N) {
			answer += 1; // 퀸을 놓은 경우의 수 증가
			return;
		}
		
		for(int c=1; c<=N; c++) {
			col[rowNo] = c;
			//if(!isAvailable(rowNo)) { // 현재 row가 유망한지 검사해서 유망하지 않으면 다음 가지로 안감.
			setQueen(rowNo+1);
			//}
		}
	}
	
	
	private static boolean isAvailable(int rowNo) {
		
		for(int k=1; k<rowNo; k++) { // k : 비교대상
			if(col[k] == col[rowNo] || 
					(Math.abs((col[k] - col[rowNo])) == rowNo-k)) return false;
		}
		return true;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		
		setQueen(1);
		System.out.println(answer);
		
	}
}