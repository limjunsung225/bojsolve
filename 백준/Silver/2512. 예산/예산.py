import sys
input= sys.stdin.readline

def is_possible(mid, arr, M):
    sum = 0
    for i in range(len(arr)):
        if mid > arr[i]:
            sum += arr[i]
        else:
            sum += mid
    if sum > M:
        return False
    else:
        return True

N = int(input())
arr = list(map(int,input().split()))
left, right, sum = 0, 0, 0

for i in range(N):
    sum += arr[i]
    right = max(arr[i], right)

M = int(input())

if sum <= M:
    print(right)
else:
    while left + 1 < right:
        mid = (left + right) // 2
        if is_possible(mid, arr, M):
            left = mid
        else:
            right = mid
    print(left)