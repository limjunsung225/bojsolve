import sys
input =sys.stdin.readline

minus = 0
time = 0
li = []

for _ in range(11):
    word1, word2 = map(int, input().split())
    li.append((word1, word2))
li.sort()

for i in range(len(li)):
    minus += (time + li[i][0] + 20 * li[i][1])
    time += li[i][0]

print(minus)