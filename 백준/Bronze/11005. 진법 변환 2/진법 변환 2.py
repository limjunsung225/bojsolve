import sys
input= sys.stdin.readline
N, B = map(int, input().split())
s = ''
li = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

while N:
    s += str(li[N%B])
    N //= B

print(s[::-1])