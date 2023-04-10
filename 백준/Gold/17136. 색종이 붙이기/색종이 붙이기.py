import sys
input =sys.stdin.readline


def isOkay(li, x, y, size):  # 맵 사이즈를 넘지 않는지 확인
    if x + size > 10 or y + size > 10:
        return False
    for i in range(x, x + size):
        for j in range(y, y + size):
            if li[i][j] == 0:
                return False
    return True


def dfs(li, canMake_cnt, cnt):
    global result
    if result != -1 and sum(cnt) > result: # 만약 이미 최소값보다 더 사용했으면 프루닝
        return

    if canMake_cnt == 0:  # 만약 맵을 모두 덮었다면
        if result == -1:
            result = sum(cnt)
        else:
            result = min(result, sum(cnt))
        return

    x = -1
    y = -1
    for i in range(10):
        for j in range(10):
            if li[i][j] == 1:
                x = i
                y = j #여기서 부터 색종이 넣기 시작
                break
        if (x != -1 and y != -1) and li[x][y] == 1:
            break

    # x, y 위치에 대입 가능한 색종이 탐색
    for i in range(1, 6):
        if cnt[i - 1] == 5:  # 5개 이상은 사용할 수 없다.
            continue
        if isOkay(li, x, y, i):  # 색종이 놓을 수 있는지 확인
            canMake_li = []
            for m in range(x, x + i):
                for n in range(y, y + i):
                    li[m][n] = 0
                    canMake_li.append((m, n))
            cnt[i - 1] += 1
            dfs(li, canMake_cnt - i ** 2, cnt)
            cnt[i - 1] -= 1
            for k, t in canMake_li:  # 다시 1로 수정
                li[k][t] = 1


graph = [list(map(int, input().split())) for _ in range(10)]
paper = 0
for i in range(10):
    paper += graph[i].count(1)
result = -1

dfs(graph, paper, [0, 0, 0, 0, 0])
print(result)