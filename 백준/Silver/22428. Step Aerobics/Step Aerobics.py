import sys
input =sys.stdin.readline

while True:
    N = int(input())
    flag = False
    if N == 0:
        exit()
    li = list(map(str,input().split()))
    result = 0

    l_cnt = 0
    r_cnt = 0

    for i in li:
        if i == "lu":
            l_cnt += 1
            if l_cnt >=2:
                l_cnt = 1
        if i == "ru":
            r_cnt += 1
            if r_cnt >=2:
                r_cnt = 1
        if i == "ld":
            l_cnt -= 1
            if l_cnt <=0:
                l_cnt = 0
        if i == "rd":
            r_cnt -= 1
            if r_cnt <=0:
                r_cnt = 0

        if l_cnt == 1 and r_cnt == 1 and not flag:
            result += 1
            flag = True
        if l_cnt == 0 and r_cnt ==0 and flag:
            result += 1
            flag = False

    print(result)