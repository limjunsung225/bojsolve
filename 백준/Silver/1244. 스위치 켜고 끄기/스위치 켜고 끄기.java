import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 스위치의 개수
		int [] arr = new int[N]; // 스위치의 상태
		
		for (int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int stu_num = sc.nextInt(); // 학생 수
		for (int i=0;i<stu_num;i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			if (gender==1) { // 남자면
				for(int k=0;k<N;k++) {
					if((k+1)%num==0) {
						if(arr[k]==0) {arr[k]=1;}
						else {arr[k]=0;}
					}
				}
			}else if(gender==2) {
				num--; // 인덱스 조정 
				if (arr[num]==0) {arr[num]=1;} // 우선 여학생 본인자리 바꾸고 시작
				else {arr[num]=0;}
				
				// 좌우로 몇번까지 갈지
				int check = Math.min(Math.abs(num-(arr.length-1)), num);
				for (int t=1; t<=check;t++) {
					if (arr[num-t]==arr[num+t]) { // 좌우가 대칭이면
						if(arr[num-t]==1) { // 1은 0으로
							arr[num-t]=0;
							arr[num+t]=0;
						}else {arr[num-t]=1;arr[num+t]=1;} // 0은 1로
					
					}else break;
				}
			}
		}
		String tmp = "";
		for(int i:arr) {
			tmp += Integer.toString(i)+" ";
			
			if (tmp.length()==40) {
				System.out.println(tmp);
				tmp = "";
			}
		}
		if (tmp.length()<40) {
			System.out.println(tmp);
		}
	}
}