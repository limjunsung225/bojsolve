import sys
input= sys.stdin.readline

word= input().rstrip()
a_cnt = 0
b_cnt = 0

for i in word:
    if i == ":":
        a_cnt += 1
    if i == "_":
        b_cnt += 1

res = len(word) + a_cnt + ((b_cnt)*5)
print(res)