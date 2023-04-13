import sys
input =sys.stdin.readline

N = int(input())
li = list(map(int,input().split()))
li_dict = dict()
cnt = 0
max_cnt = 0
for i in li:
    if i not in li_dict.keys():
        li_dict[i] = 1
        cnt += 1
        max_cnt = max(max_cnt,cnt)
    else:
        li_dict[i] = 0
        cnt -= 1
print(max_cnt)