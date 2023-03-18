import sys
input =sys.stdin.readline

cnt = sys.maxsize
N = int(input())
for _ in range(N):
    a, b= map(int,input().split())
    if a<=b:
        cnt = min(cnt,b)
if cnt == sys.maxsize:
    print(-1)
else:
    print(cnt)