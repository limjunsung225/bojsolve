import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int N, pcnt, time;
	static int[][] graph;
	static boolean[] check;
	static ArrayList<int[]> people = new ArrayList<>();
	static ArrayList<int[]> stairs = new ArrayList<>();

	public static int move(ArrayList<Integer> s_li, int[] stairs) {
		int count = 0;
		int d_count = 0;
		ArrayList<Integer> q = new ArrayList<>();
		while (!q.isEmpty() || d_count > 0 || !s_li.isEmpty()) { // 이동중이거나, 계단을 타고있거나, 대기중인사람이 잇으면 계속
			while (d_count > 0) { // 대기하는 사람이 있지만
				if (q.size() == 3) { // 사람이 다 찼으면 못들어감
					break;
				}
				q.add(stairs[2]); // 그렇지 않다면 내려가는 사람에 추가
				d_count--; // 대기중인 인원 count 감소
			}

			for (int i = s_li.size() - 1; i >= 0; i--) { // 이동중인 인원이 있을때
				s_li.set(i, s_li.get(i) - 1); // 거리 감소
				if (s_li.get(i) <= 0) { // 계단 앞이면
					s_li.remove(i); // 삭제후
					d_count++; // 대기인원 증가
				}
			}

			for (int i = q.size() - 1; i >= 0; i--) { // 내려가는 인원이 있을때
				q.set(i, q.get(i) - 1); // 시간 count 감소
				if (q.get(i) <= 0) { // 다 내려갔으면 remove
					q.remove(i);
				}
			}
			count++; // time 1초증가
		}
		return count;
	}

	public static void makeGraph() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = graph[i][j];
				if (num != 0) {
					if (num == 1) {
						pcnt++; // 사람수 추가
						people.add(new int[] { i, j }); // 사람 위치 저장
					} else {
						stairs.add(new int[] { i, j, num }); // 계단 위치 저장
					}
				}
			}
		}
	}

	public static void comb(int cnt) {
		if (cnt == pcnt) {
			ArrayList<Integer> s_li1 = new ArrayList<>();
			ArrayList<Integer> s_li2 = new ArrayList<>();

			for (int i = 0; i < pcnt; i++) { // 조합으로 계단 1 , 2를 만들고
				if (check[i]) {
					s_li1.add(people.get(i)[0]);
				} else {
					s_li2.add(people.get(i)[1]);
				}
			}
			int count = Math.max(move(s_li1, stairs.get(0)), move(s_li2, stairs.get(1))); // 두 개의 계단중 소요시간이 긴만큼이 최소한 걸리게 되고 
			time = Math.min(count, time); // 최소값으로 갱신한다.
			return;
		}
		check[cnt] = false;
		comb(cnt + 1);
		check[cnt] = true;
		comb(cnt + 1);
	}

	public static void calDist() { 
		for (int i = 0; i < people.size(); i++) {
			int d1 = Math.abs(people.get(i)[0] - stairs.get(0)[0]) + Math.abs(people.get(i)[1] - stairs.get(0)[1]); // 멘헤튼 거리 계산
			int d2 = Math.abs(people.get(i)[0] - stairs.get(1)[0]) + Math.abs(people.get(i)[1] - stairs.get(1)[1]);
			people.get(i)[0] = d1;
			people.get(i)[1] = d2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(str[j]);
				}
			}
			pcnt = 0;
			time = Integer.MAX_VALUE; // 최종 시간
			people.clear();
			stairs.clear();
			makeGraph(); // 맵 만들어주고
			calDist(); // 거리를 계산한다.
			check = new boolean[pcnt]; // 계단을 선택한다.
			comb(0); // combination
			sb.append("#").append(tc).append(" ").append(time+1);
			System.out.println(sb.toString());
		}
	}
}