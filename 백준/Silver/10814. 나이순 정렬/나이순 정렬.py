import sys
input =sys.stdin.readline

N = int(input())
li = []
for _ in range(N):
    k = list(map(str,input().split()))
    k[0] = int(k[0])
    li.append(k)

new_li = sorted(li, key=lambda x:(x[0]))

for i in new_li:
    print(*i)