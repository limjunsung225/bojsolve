import sys
input =sys.stdin.readline

N = int(input())
li = list(map(int,input().split()))
ans = 0
for i in range(len(li)):
    ans += li[i]

li.sort()
cnt = 0

for i in range(len(li)-1):
    ans -= li[i]
    cnt += (ans * li[i])
    
print(cnt)