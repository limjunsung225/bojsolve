import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] graph;
	static int N, M, D; // 행의수, 열의수 , 공격거리
	static int[] numbers = new int[3]; // 가능한 궁수 조합
	static int max_result = 0;  // 최대 적의 수

	private static int[][] copyGraph() {  
		int[][] new_graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				new_graph[i][j] = graph[i][j];
			}
		}
		return new_graph;
	}
	
// 이러한 복사방법도 있지만 위에가 훨씬 가독성 좋은듯
//	public static void CopyStore_Graph() { // 저장용 그래프   
//		new_graph = new int[N][M];
//		for (int i = 0; i < new_graph.length; i++) {
//			System.arraycopy(graph[i], 0, new_graph[i], 0, new_graph[0].length);
//		}
//	}


	private static void comb(int cnt, int start) {
		if (cnt == 3) { // 여기서부터 이제 궁수로 적을 찾는 함수를 실행
			int[][] new_graph = copyGraph(); // 우선 그래프를 복사해두고 bfs를 시작한다
			max_result = Math.max(max_result, bfs(numbers, new_graph)); // 돌고 나서 return값을 저장하고 max_result랑 비교해서돌때마다 갱신
			return;
		}

		for (int i = start; i < M; i++) { // 궁수의 조합을 구성한다.
			numbers[cnt] = i;
			comb(cnt+1,i+1);
		}
	}

	
	private static int bfs(int[] numbers, int[][] new_graph) {  // 궁수의 조합과 복사된 그래프로 bfs
		int time = N;
		int game_result = 0; // 몇명의 궁수가 죽는가 

		while (time > 0) { // N번만큼 게임이 진행된다

			ArrayList<int[]> diedList = new ArrayList<>(); // 죽인 병사를 담을 배열

			for (int i = 0; i < numbers.length; i++) { // 각 궁수마다 잡을 수 있는 적의 위치를 저장한다.
				
				int[] index = new int[2]; // 병사의 위치
				int min_distance = 200;  // 거리설정 
				
				for (int j = 0; j < M; j++) {// 우선 탐색순위는 왼쪽부터
					for (int k = time-1; k >= 0; k--) {// 행 탐색
						
						int distance = Math.abs(k-time) + Math.abs(numbers[i]-j);
						if (new_graph[k][j] == 1 && distance <= D) {// 적이 존재하고 거리가 D이하면 그 병사를 쏠 수 있다.

							if (distance < min_distance) { // 더 가까운 거리를 우선한다.
								min_distance = distance;
								// 적군 좌표 저장
								index[0] = k;
								index[1] = j;
							}
							break;
						}
					} 
				} 
				if (min_distance != 200) {// 공격할 적군이 있었다면
					diedList.add(new int[] { index[0], index[1] });
				}
			} 

			for (int i = 0; i < diedList.size(); i++) { // 적군 제거
				if (new_graph[diedList.get(i)[0]][diedList.get(i)[1]] != 0) {
					new_graph[diedList.get(i)[0]][diedList.get(i)[1]] = 0; // 제거했으니 0으로
					++game_result;
				}
			}
			time -= 1;// 병사를 위로 일일이 찾아서 전진하는게 아닌 궁수의 위치를 바꾼다.
		}
		return game_result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		// 한번에 같은 병사를 공격하는 것을 생각해서 병사의 위치 정보를 어떠한 배열안에 담아둬야될듯
		System.out.print(max_result);
	}

}