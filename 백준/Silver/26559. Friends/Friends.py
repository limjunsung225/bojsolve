import sys
input =sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    li_dict = dict()
    temp = ""
    for _ in range(N):
        name, num = map(str,input().split())
        num = int(num)

        li_dict[name] = num

    li_dict = dict(sorted(li_dict.items(), key = lambda x:(-x[1])))
    for key, values in li_dict.items():
        temp += key
        temp += ", "

    temp = temp[:-2]
    print(temp)