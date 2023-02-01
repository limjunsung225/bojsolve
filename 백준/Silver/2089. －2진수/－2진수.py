import sys
input= sys.stdin.readline

N = int(input())
if N == 0:
    print(0)
else:
    temp = ""
    while N:
        temp += str(N%2)
        N //= 2
        N *= -1
    k = temp[::-1]
    print(k)