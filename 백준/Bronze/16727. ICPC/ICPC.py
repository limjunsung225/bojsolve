import sys
input= sys.stdin.readline
a, b = map(int, input().split())
c, d = map(int, input().split())
n = a + d
m = b + c
if n == m:
    if a == c:
        print("Penalty")
    elif a > c:
        print("Esteghlal")        
    else:
        print("Persepolis")
elif n > m:
    print("Persepolis")
else:
    print("Esteghlal")