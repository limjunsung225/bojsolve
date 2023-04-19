import sys
input=sys.stdin.readline
N, M = map(int,input().split())

li = [[] for a in range(N)]
for i in range(M):
    a,b,c = list(map(int, sys.stdin.readline().split()))
    for j in range(a-1,b):
        li[j] = c
for i in li:
    if i:
        print("{}".format(i),end= " ")
    else:
        print("{}".format(0),end= " ")