import sys
input =sys.stdin.readline

N = int(input())
graph = []
row_cnt = 0
col_cnt = 0
for _ in range(N):
    graph.append(list(map(str,input().rstrip())))

for i in range(N):
    flag = True
    for j in range(N-1):
        if graph[i][j] == "." and flag:
            if graph[i][j+1] == ".":
                row_cnt += 1
                flag = False
        elif graph[i][j] == "X":
            flag = True

for i in range(N):
    flag = True
    for j in range(N-1):
        if graph[j][i] == "." and flag:
            if graph[j+1][i] == ".":
                col_cnt += 1
                flag = False
        elif graph[j][i] == "X":
            flag = True

print("{} {}".format(row_cnt, col_cnt))