import sys
input =sys.stdin.readline
import itertools
N , L , R, X = map(int,input().split()) #  문제개수, L<=합M=R , 가장어려운문제 ,가장쉬운문제 난이도차이
li = list(map(int,input().split())) # 문제의 난이도
li.sort()
result = 0

for i in range(1,N+1):
    comb_li = list(itertools.combinations(li,i))
    temp = 0
    for j in comb_li:
        if L<=sum(j)<=R:
            if j[-1]-j[0]>=X:
                result += 1
print(result)