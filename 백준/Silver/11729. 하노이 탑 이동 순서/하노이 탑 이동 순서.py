import sys
input = sys.stdin.readline


def hanoi(cnt, a, b):
    if cnt > 1:
        hanoi(cnt - 1, a, 6 - a - b)
    print(a, b)

    if cnt > 1:
        hanoi(cnt - 1, 6 - a - b, b)


N = int(input())
print("{}".format((2 ** N) - 1))
hanoi(N, 1, 3)