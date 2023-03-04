import sys
input =sys.stdin.readline
from collections import defaultdict

N = int(input())
li_dict = defaultdict(list)

for _ in range(N):
    a , b = map(str,input().split())
    li_dict[a].append(b)

k = sorted(li_dict.items(), key = lambda x:(x[0],x[1][0]))

for i in k:
    i[1].sort(reverse=True)
    for j in range(len(i[1])):
        print("{} {}".format(i[0],i[1][j]))