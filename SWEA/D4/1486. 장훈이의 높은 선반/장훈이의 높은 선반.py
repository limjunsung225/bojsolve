import itertools
from itertools import combinations

T = int(input())
for tc in range(1,T+1):
    N ,B = map(int,input().split()) # 점원수, 최소탑의높이
    li = list(map(int,input().split()))
    res = 10**7
    flag = 0
    for i in range(1,N+1):
        comb_li = list(itertools.combinations(li,i))
        for com in comb_li:
            if sum(com)==B:
                print("#{} {}".format(tc,0))
                flag += 1
                break

            elif sum(com)>B:
                res = min(res, sum(com)-B)

        if flag !=0:
            break

    if flag == 0:
        print("#{} {}".format(tc,res))