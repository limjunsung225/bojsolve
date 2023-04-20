import sys
input= sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    li = []
    for i in range(N):
        li.append(input().rstrip())
    li.sort()
    flag = True
    for i in range(N-1):
        if li[i] == li[i+1][0:len(li[i])]:
            flag = False
            break
    if flag:
        print("YES")
    else:
        print("NO")