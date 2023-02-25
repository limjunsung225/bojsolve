import sys
input = sys.stdin.readline
import itertools
from itertools import combinations

N,K = map(int,input().split())
li = [ input().rstrip() for _ in range(N) ]
alp_li = ['a','c','i','n','t']

    
com_li = set()
check = True

if K <5:
    print(0)
    exit()
else:
    K = K-5
    
for i in range(N):
    li[i] = li[i][4:-4]
    for j in li[i]:
        if j not in alp_li:
            com_li.add(j)
            
com_li = list(com_li)
result = 0


if check:
        if K > len(com_li):
            K = len(com_li)
        for comb in combinations(com_li,K):
            cnt = 0
            for x in li:
                for y in x:
                    if y not in comb and y not in alp_li:
                        break
                else:
                    cnt+=1
            result = max(result,cnt)
        print(result)
else:
    print(0)