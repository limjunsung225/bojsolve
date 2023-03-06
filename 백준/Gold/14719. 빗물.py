# [Gold V] 빗물 - 14719 

[문제 링크](https://www.acmicpc.net/problem/14719) 

### 성능 요약

메모리: 34160 KB, 시간: 264 ms

### 분류

구현, 시뮬레이션



import sys
input= sys.stdin.readline
from collections import deque

H, W = map(int,input().split()) # 세로길이, 가로길이
graph = [[0]*W for _ in range(H)]
li = list(map(int,input().split()))

dx = [-1,0,0,1]
dy = [0,1,-1,0]

for i in range(H):
    for j in range(W):
        if li[j] !=0:
            graph[H-i-1][j] =1
            li[j]-=1

result = 0

for i in range(H):
    for j in range(W):
        flag = 0  # 2가 되면 물로 바꿀 수 있다.
        if graph[i][j] == 0:

            for cnt1 in range(j):
                if graph[i][cnt1] == 1:
                    flag += 1
                    break

            for cnt2 in range(1,W-j):
                if graph[i][j+cnt2] == 1:
                    flag += 1
                    break

        if flag == 2:
            graph[i][j] = -1
            result += 1

print(result)
