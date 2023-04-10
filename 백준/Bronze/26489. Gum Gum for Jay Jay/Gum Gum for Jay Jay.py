import sys
input= sys.stdin.readline

cnt = 0
while True:
    word = input().rstrip()
    if len(word)==0:
        break
    cnt+=1
print(cnt)