import sys
input = sys.stdin.readline
from collections import deque

def order(num,direction):
    if direction == "D":
        move_d(num)
    elif direction == "S":
        move_s(num)
    elif direction =="L":
        move_l(num)
    elif direction == "R":
        move_r(num)

def move_d(num):
    num = num * 2
    if num > 9999:
        num = num % 10000
    return num

def move_s(num):
    if num == 0:
        num = 9999
    else:
        num = num - 1
    return num

def move_l(num):
    first = num%1000
    end = num // 1000
    num = first * 10 + end
    return num

def move_r(num):
    first = num % 10
    end = num // 10
    num = first*1000 + end
    return num


def go(s, t):
    queue = deque()
    visited = set()
    queue.append((s, ""))
    visited.add(s)
    while queue:
        now, temp = queue.popleft()
        if now == t:
            print(temp)
            return
        tmp = move_d(now)
        if tmp not in visited:
            visited.add(tmp)
            queue.append((tmp, temp + "D"))

        tmp = move_s(now)
        if tmp not in visited:
            visited.add(tmp)
            queue.append((tmp, temp + "S"))

        tmp = move_l(now)
        if tmp not in visited:
            visited.add(tmp)
            queue.append((tmp, temp + "L"))

        tmp = move_r(now)
        if tmp not in visited:
            visited.add(tmp)
            queue.append((tmp, temp + "R"))

# bfs 로 모든 방향으로 전부 명령어를 1 level 씩 증가시키면서
# 만약 num2와 값이 일치할 때 해당 경로를 그대로 출력하면 될듯.
for _ in range(int(input())):
    num1, num2 = map(int, input().split())
    go(num1, num2)