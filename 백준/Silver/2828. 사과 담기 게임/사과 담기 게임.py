N, M = map(int,input().split())
T = int(input())

result = 0
start = 1
end = M

while T:
    num = int(input())

    flag = True
    while flag:
        if start <= num and num <= end:
            flag = False
        elif start > num:
            start -= 1
            end -= 1
            result += 1
        else:
            start += 1
            end += 1
            result += 1

    T -= 1
print(result)