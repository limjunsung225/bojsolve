import sys
import itertools
from itertools import permutations
input =sys.stdin.readline

a, b = map(str,input().rstrip().split())
c, d = map(str,input().rstrip().split())

li = set()
li.add(a) , li.add(b), li.add(c), li.add(d)
li = list(li)
li = li + li
li.sort()

com_li = list(itertools.permutations(li,2))
result = []
for i in com_li:
    if i not in result:
        result.append(i)
        
result.sort()
for j in result:
    print(" ".join(map(str,j)))