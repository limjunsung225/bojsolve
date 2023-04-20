import sys
input= sys.stdin.readline

N , M , C = map(int,input().split())
li = [[0]*(C+1)] + [ [0] + list(map(int,input().split())) for _ in range(C)]
dp = [ [0]*(M+1) for _ in range(N+1) ]
li_a = [0] + list(map(int,input().split()))
li_b = [0] + list(map(int,input().split()))

for i in range(1,N+1):
    for j in range(1,M+1):
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + li[li_a[i]][li_b[j]])

# print(li)
# print(dp)
print(dp[N][M])