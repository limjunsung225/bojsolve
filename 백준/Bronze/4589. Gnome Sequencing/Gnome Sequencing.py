t = int(input())
print("Gnomes:")
for _ in range(t):
    beard = list(map(int, input().split()))
    if (beard[1] - beard[0]) * (beard[2] - beard[1]) > 0:
        print("Ordered")
    else:
        print("Unordered")