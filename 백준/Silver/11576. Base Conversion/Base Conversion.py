import sys
input =sys.stdin.readline
A,B = map(int,input().split())
m = int(input())-1
n, ans = 0, []
for i in map(int,input().split()):
    n += i * A**m
    m-=1
    
while n:
    ans.append(n%B)
    n//=B
print(*ans[::-1])