import sys
input =sys.stdin.readline

N = int(input())
start = 0
end = ((2**63)**0.5)+1
result = 0

while start <= end:
    cnt = int((start+end)//2)

    if cnt ** 2 >= N:
        result = cnt
        end = cnt - 1
    else:
        start = cnt + 1

print(result)