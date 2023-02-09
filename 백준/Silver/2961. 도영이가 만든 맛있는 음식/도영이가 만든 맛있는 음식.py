import sys
input= sys.stdin.readline
import itertools
from itertools import combinations

N = int(sys.stdin.readline())
li = []
result = 10**10
new_li = []

for i in range(N):
    li.append(list(map(int,input().split())))
for i in range(1, len(li)+1):
    new_li.append(itertools.combinations(li, i))

for i in new_li:
    for j in i:
        s_cnt = 1
        b_cnt = 0
        for k in j:
            s_cnt *= k[0]
            b_cnt += k[1]
        result = min(result, abs(s_cnt-b_cnt))
        if result == 0:
            print(result)
            exit()

print(result)