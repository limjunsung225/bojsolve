import sys
input= sys.stdin.readline

N = int(input())
a = 0
b = 0

for i in range(N+1):
    a += i
    b += i**3
print(a)
print(a**2)
print(b)