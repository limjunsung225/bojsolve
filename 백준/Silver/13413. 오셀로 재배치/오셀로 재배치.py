import sys
input= sys.stdin.readline

t = int(input())

for _ in range(t):
    N = int(input())
    li_1 = list(map(str, input().rstrip("\n")))
    li_2 = list(map(str, input().rstrip("\n")))
    cnt = []

    for i in range(N):
        if li_1[i] != li_2[i]:
            cnt.append(li_1[i])

    if not cnt:
        print(0)

    elif cnt.count("B") >= cnt.count("W"):
        print(cnt.count("B"))

    else:
        print(cnt.count("W"))