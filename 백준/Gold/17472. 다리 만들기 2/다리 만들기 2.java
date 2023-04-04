import java.util.*;
import java.io.*;

public class Main {
	
	static int N ,M,check,check2,length;
	static int[][] graph ;
	static int[][] visited ;
	static int temp = 0;
	static int island = 0;
	static int[] parents;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static ArrayList<ArrayList<int[]>>bridge = new ArrayList<>();	
	
	static class Node implements Comparable<Node>{
		
		int start;
		int end;
		int w;
		
		Node(int start, int end, int w){
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}

	public static boolean isOkay(int x, int y) { // 맵위 범위를 벗어나지 않는지, 방문한적 있지는 않은지
		if (x <= -1 || x >= N || y <= -1 || y >= M || visited[x][y]!=0) {
			return false;
		}
		return true;
	}
	
	public static void findDistanceRow() { // 섬과 섬 사이의 거리를 구하는 함수

		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<>();
			check = -1;
			length = 0;
			for (int j = 0; j < M; j++) {
				if (stack.isEmpty()) { // 비었을때는 섬의 번호가 나올때 넣는다.
					if (graph[i][j] != 0) {
						stack.add(graph[i][j]);
						check = graph[i][j]; // 섬의 번호 저장
					}
				} else if (!stack.isEmpty()) {
					if (graph[i][j] == 0) { // 0일때는 거리측정을 위해 0을 넣어주고
						stack.add(0);
					} else if (graph[i][j] == check) {
						stack.add(graph[i][j]);
					} else if (graph[i][j] != check) { // 새로운 섬을 만나게 되면
						check2 = graph[i][j];
						while (stack.peek() == 0) {
							stack.pop();
							length += 1;
						}
						stack.clear(); // 스택 비워줘야하고
						if (length >= 2) {
							length = 0;
						}
					}
				}
			}
		}
	}
	
	static boolean check(int i, int j) {
		if(0<=i&&i<N && 0<=j&&j<M)return true;
		return false;
	}
	
	static void dfs(int i, int j) {	
		
		visited[i][j] = 1;
		temp++;
		graph[i][j] = island;			
		bridge.get(island).add(new int[] {i, j});	
		
		for(int d=0; d<4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			if(check(nx,ny) && visited[nx][ny]==0 && graph[nx][ny]==1) {
				dfs(nx,ny);
			}
		}
	}
	
	
	static void callbridge(int i, int j, int dir, int me, int len) {
		
		visited[i][j] = 1;
		
		int nx = i+dx[dir];
		int ny = j+dy[dir];
		
		if(check(nx,ny) && visited[nx][ny]==0 && graph[nx][ny]!=me) {
			
			if(graph[nx][ny]==0) {
				callbridge(nx, ny, dir, me, len+1);
			}else if(graph[nx][ny]>0) {
				pq.add(new Node(me, graph[nx][ny], len));	
				return;
			}
		}
	}
	
	static void makeset() {
		for(int i=1; i<=island; i++) {
			parents[i] = i;
		}
	}
	
	static void unionset(int node1, int node2) {
		int node_1 = findset(node1);
		int node_2 = findset(node2);
		
		if(node_1 > node_2)parents[node_2] = node_1;
		else parents[node_1] = node_2;
	}
	
	static int findset(int nodenum) {
		if(parents[nodenum]==nodenum)return nodenum;
		else return parents[nodenum] = findset(parents[nodenum]);
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		island = 0;
		bridge.add(new ArrayList<>());
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j]==1 && visited[i][j]==0) {
					island++;
					
					bridge.add(new ArrayList<>());
					dfs(i,j);
				}
			}
		}
		
		for(int i=1; i<=island; i++) {		
			int nowplace = i;
			
			for(int j=0; j<bridge.get(i).size(); j++) {	
				int[] now = bridge.get(i).get(j);
				int nowi = now[0];
				int nowj = now[1];
				
				visited = new int[N][M];			
				for(int d=0; d<4; d++) {				
					visited = new int[N][M];
					callbridge(nowi, nowj, d, nowplace, 0);
				}
			}
		}
		
		
		parents = new int[island+1];
		
		int minlen = 0;
		int result = 1;
		
		makeset();
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			int nowfrom = now.start;
			int nowto = now.end;
			int nowweight = now.w;
			
			if(nowweight<2)continue;
			if(findset(nowfrom) == findset(nowto))continue;		
			else {
				unionset(nowfrom, nowto);
				minlen+=nowweight;
				result++;
			}
			if(result == island)break;
		}
		if(result==island)System.out.println(minlen);
		else System.out.println(-1);
	}
}