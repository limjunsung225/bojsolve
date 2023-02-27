import sys
input =sys.stdin.readline

N = int(input())
graph = [ [0]*101 for _ in range(101) ] 

for _ in range(N):
    a , b =map(int,input().split())
    for i in range(a,a+10):
        for j in range(b,b+10):
            graph[i][j] = 1

cnt = 0

dx = [-1,0,0,1]
dy = [0,1,-1,0]

for i in range(1,101):
    for j in range(1,101):
        if graph[i][j] == 1:
            flag = 0
            for check in range(4):
                nx = i + dx[check]
                ny = j + dy[check]

                if graph[nx][ny] == 1:
                    flag += 1
            
            if flag == 3:
                cnt += 1
            elif flag == 2:
                cnt += 2
            else:
                pass

print(cnt)