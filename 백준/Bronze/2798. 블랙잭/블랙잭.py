import sys
input =sys.stdin.readline
import itertools
from itertools import combinations

N, M = map(int,input().split())

li = list(map(int,input().split()))
li.sort()
new_li = list(itertools.combinations(li,3))
ans = 10**7
result =0
for i in new_li:
    if (M-sum(i)) >= 0 and (M-sum(i)) <= ans:
        ans = (M-sum(i))
        result = sum(i) 
print(result)