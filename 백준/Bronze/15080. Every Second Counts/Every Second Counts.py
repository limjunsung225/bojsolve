import sys
input= sys.stdin.readline

a, b, c = map(int, input().split(':'))
d, e, f = map(int, input().split(':'))
g = a*3600 + b*60 + c
h = d*3600 + e*60 + f
if g > h:
    print(h-g+3600*24)
else:
    print(h-g)