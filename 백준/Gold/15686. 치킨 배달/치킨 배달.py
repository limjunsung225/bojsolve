import sys

input = sys.stdin.readline

from itertools import combinations


n, m = map(int,input().split())

graph = []

for _ in range(n):

    graph.append(list(map(int,input().split())))

zip = []
chick = []

for i in range(n):

    for j in range(n):

        if graph[i][j] == 1:

            zip.append((i,j))
        
        elif graph[i][j] == 2:

            chick.append((i,j))

result= 10**7

for random in combinations(chick, m):

    cnt = 0

    for k in zip:

        cnt += min([abs(k[0]-i[0])+abs(k[1]-i[1]) for i in random])

        if result <= cnt: 

            break

    if cnt < result: 

        result = cnt
 
print(result)



