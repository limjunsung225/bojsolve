import sys
input= sys.stdin.readline

N , D , K , C = map(int,input().split()) # 접시수, 초밥 가지수, 연속접시, 쿠폰번호
result = 0
li = [ int(input()) for _ in range(N) ]


for i in range(N):
    if i+K>N:
        new_li = li[i:N]
        for j in range(K-len(new_li)):
            new_li.append(li[j])
    else:
        new_li = li[i:i+K]

    new_li.append(C)
    result = max(result,len(list(set(new_li))))

print(result)