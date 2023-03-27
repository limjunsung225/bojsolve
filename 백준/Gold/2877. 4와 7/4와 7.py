import sys
input =sys.stdin.readline

K = int(input())
K += 1
cnt = str(bin(K)[2:])
cnt = cnt[1:]
cnt = cnt.replace("1","7")
cnt = cnt.replace("0","4")
print(cnt)