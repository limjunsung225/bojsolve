import sys
input= sys.stdin.readline

N = int(input())
li = list(map(int,input().split()))
total_li = [0] * N
total_li[0] = li[0]
for i in range(1,len(li)):
    total_li[i] = li[i] + total_li[i-1]

T = int(input())
for _ in range(T):
    a, b = map(int,input().split())
    if a==0:
        res = total_li[b]
    else:
        res = total_li[b] - total_li[a-1]
    print(res)