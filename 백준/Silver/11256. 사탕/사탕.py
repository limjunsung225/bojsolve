import sys
input= sys.stdin.readline

for _ in range(int(input())):
    k , N = map(int,input().split())
    li = []
    
    for _ in range(N):
        r, c = map(int,input().split())
        ans = r*c
        li.append(ans)
    
    li.sort(reverse=True)
    answer = 0
    
    while k> 0:
        k-= li[answer]
        answer += 1
    print(answer)