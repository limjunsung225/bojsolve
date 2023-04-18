import sys
input= sys.stdin.readline
N,M=map(int,input().split())
result = 0
if N == 0 : 
    print(0)
    exit()
else : 
    li = list(map(int,input().split()))
    w = 0
    result = 1 
    for i in li:   
        if i+w <= M : 
            w += i
        else : 
            w = i 
            result +=1
    print(result)