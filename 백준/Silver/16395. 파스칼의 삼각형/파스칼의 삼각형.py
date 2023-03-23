import sys
input= sys.stdin.readline

N , K = map(int,input().split())
li = [ [1] * i for i in range(1,N+1)]

for i in range(2,N):
    for j in range(1,i):
        li[i][j] = li[i-1][j-1] + li[i-1][j]      
print(li[N-1][K-1])