import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] nineArr=new int[9];
	static int[] sevenArr;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0;i<9;i++) {
			nineArr[i]=Integer.parseInt(br.readLine());
		}
		
		sevenArr=new int[7];
		
		combination(0,0);
		
		System.out.println(sb);
	}
	
	static void combination(int cnt, int start) {
		
		if(cnt==7) {
			int sum=0;
			for(int j=0;j<7;j++) {
				sum+=sevenArr[j];
			}
			if(sum==100) {
				for(int j=0;j<7;j++) {
					sb.append(sevenArr[j]).append('\n');
				}
			}
			return;
			
		}
		for(int i=start; i<9 ;i++) {
			sevenArr[cnt]=nineArr[i];
			combination(cnt+1, i+1);
		}
	}

}