import sys
input =sys.stdin.readline

a, b, c, d, e = map(int,input().split())
print("{}".format((a*b)-(c*d*e)))