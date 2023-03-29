import sys
input= sys.stdin.readline

N = int(input())  # 도시의 수
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [False for _ in range(N)]
result = sys.maxsize

def dfs(start, now, cnt):
    global result

    if result < cnt:  # 이미 넘어버리면 탐색할필요없음
        return

    if start == now and False not in visited:  # 모두방문, 시작위치면
        result = min(result,cnt)
        return

    for i in range(N):
        if not graph[now][i] or visited[i]:  # 못가거나 ,방문했으면
            continue

        visited[i] = True
        dfs(start, i, cnt + graph[now][i])  #비용 더해주며 다음도시방문
        visited[i] = False

dfs(0, 0, 0)
print(result)