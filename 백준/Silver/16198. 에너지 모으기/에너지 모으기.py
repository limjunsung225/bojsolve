import sys
input= sys.stdin.readline

def dfs(marble, cnt):
    global result
    if marble == 2:
        result = max(result, cnt)
        return
    for i in range(1, marble-1):
        tmp = li.pop(i)
        dfs(marble-1, cnt+li[i-1]*li[i])
        li.insert(i, tmp)
    return result

N = int(sys.stdin.readline().strip())
li = list(map(int, sys.stdin.readline().split()))
result = 0
print(dfs(N,0))