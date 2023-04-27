N, M, K = map(int, input().split())
home = list(map(int, input().split()))
rock = sorted(map(int, input().split()))
li = []

for i in range(K - 1):

    li.append((rock[i], sum(home[rock[i] - 1:rock[i + 1] - 1])))

li.append((rock[- 1], sum(home[rock[-1] - 1:])))
li.sort(key=lambda x: (-x[1], x[0]))
li = sorted([x[0] for x in li[:M]])

for i in li:
    print(i)