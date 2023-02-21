import sys
input = sys.stdin.readline
from collections import deque

def bfs(v):
    q = deque([])
    q.append(v)
    visited = [ False ] * (N+1)
    visited[v] = True
    cnt = 1

    while q:
        now = q.popleft()
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                cnt += 1
                q.append(i)
    return cnt

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[b].append(a)

result = []
max_cnt = 0

for i in range(1, N + 1):
    tmp = bfs(i)
    if max_cnt == tmp:
        result.append(i)
    if max_cnt < tmp:
        max_cnt = tmp
        result = []
        result.append(i)

print(*result)