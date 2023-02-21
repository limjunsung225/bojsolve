import sys
input = sys.stdin.readline

def solution():

    ans = 2147483647
    weight = 0
    price = 0    
    result = 0

    for i in range(N):  #전부 다더해서 
        result += li[i][0]

    if result < M:  #원하는 무게가 안되면 -1 리턴 
        return -1


    for i in range(N):
        weight += li[i][0] #무게를 더하면서 

        if i>=1 and li[i][1] == li[i-1][1]: #무게가 달라지지 않았으면 
            price += li[i][1] #가격을 더한다
        else:
            price = 0 #무게가 달라졌으면 더하지 않는다 

        if weight >= M: 
            ans = min(ans, li[i][1]+price) #하나만 샀을때와 , 차근차근 더했을때의 가격중 싼 것을 출력

    return ans

N, M = map(int, input().split())

li = [list(map(int, input().split())) for _ in range(N)]

li = sorted(li, key=lambda x:(x[1], -x[0]))  # 가격은 싼순, 무게는 무거운순  

result = solution()

print(result)