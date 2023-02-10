import sys
input= sys.stdin.readline
from collections import deque
N= int(input())
k= list( i for i in range(1,N+1))
li = deque(k)

while True:
    if len(li)==1:
        print(li[0])
        exit()

    li.popleft()
    t= li.popleft()
    li.append(t)