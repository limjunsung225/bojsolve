import sys
input= sys.stdin.readline
res = 0
for _ in range(4):
    a , b= map(str,input().split())
    b = int(b)
    if a =="Es":
        res += b*21
    else:
        res += b*17
print(res)