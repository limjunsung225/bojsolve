import sys
input = sys.stdin.readline

i, j = map(int, input().split())

a = 100 - i
b = 100 - j
c = 100 - (a + b)
d = a * b

q = d // 100
r = d % 100

print("{} {} {} {} {} {}".format(a, b, c, d, q, r))
print("{} {}".format((c+q), r))