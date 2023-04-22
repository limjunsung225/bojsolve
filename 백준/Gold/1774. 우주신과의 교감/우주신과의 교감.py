import sys
input= sys.stdin.readline
import math

def findParents(a):
    if parents[a] < 0:
        return a
    parents[a] = findParents(parents[a])
    return parents[a]

def isConnected(u, v):
    u, v = findParents(u), findParents(v)
    if u == v:
        return False
    parents[u] = v
    return True

def findDistance(a, b):
    d1 = a[0] - b[0]
    d2 = a[1] - b[1]
    return math.sqrt((d1*d1)+(d2*d2))

N, M = map(int, input().split())
li = {}
parents = [-1] * 1100

for i in range(1, N+1):
    a, b = map(int, input().split())
    li[i] = (a, b)

cnt = 0
for i in range(M):
    u, v = map(int, input().split())
    if not isConnected(u, v):
        continue
    cnt += 1

edges = []
for u in range(1, N+1):
    for v in range(1, N+1):
        if u != v:
            u_pos = li[u]
            v_pos = li[v]
            d = findDistance(u_pos, v_pos)
            edges.append((d, u, v))

edges.sort()
result = 0

for i in range(len(edges)):
    w, u, v = edges[i]
    if not isConnected(u, v):
        continue
    result += w
    cnt += 1
    if cnt == N - 1:
        break

print("{:.2f}".format(result))