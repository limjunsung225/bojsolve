import sys
input= sys.stdin.readline
L, R = map(int, input().split())
if L != R:
    print("Odd", max(L,R) * 2)
elif not L and not R:
    print("Not a moose")
else:
    print("Even", L * 2)