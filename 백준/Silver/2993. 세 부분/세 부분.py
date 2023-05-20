import sys
input =sys.stdin.readline
str = input().rstrip()
len = len(str)
ans = str
for i in range(len - 2):
    for j in range(i + 1, len - 1):
        tmp = str
        tmp = tmp[:i + 1][::-1] + tmp[i + 1:j + 1][::-1] + tmp[j + 1:][::-1]
        ans = min(tmp, ans)
print(ans)