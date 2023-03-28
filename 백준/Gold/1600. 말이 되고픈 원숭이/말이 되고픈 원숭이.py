import sys
input =sys.stdin.readline
from collections import deque

K = int(input())
M,N = map(int,input().split())
visited = [[[False]*M for _ in range(N)] for _ in range(K+1)]
graph = [list(map(int,input().split())) for _ in range(N)]

normal = [(0,1),(1,0),(0,-1),(-1,0)] # 그냥 이동할 때
horse = [(1,2),(2,1),(-1,2),(-2,1),(1,-2),(2,-1),(-1,-2),(-2,-1)]

q = deque([(0,0,0,K)])
visited[0][0][0] = True
while q:
    x,y,cnt,temp = q.popleft()
    if x==N-1 and y==M-1:
        print(cnt)
        exit()

    for dx,dy in normal:
        nx = x + dx
        ny = y + dy

        if 0<=nx<N and 0<=ny<M and graph[nx][ny] == 0:

            if visited[temp][nx][ny]:
                continue

            visited[temp][nx][ny] = True
            q.append((nx,ny,cnt+1,temp))

    if temp > 0:
        temp -= 1

        for dx,dy in horse:
            nx = x + dx
            ny = y + dy

            if 0<=nx<N and 0<=ny<M and graph[nx][ny] == 0:

                if visited[temp][nx][ny]:
                    continue

                visited[temp][nx][ny] = True
                q.append((nx,ny,cnt+1,temp))

print(-1)