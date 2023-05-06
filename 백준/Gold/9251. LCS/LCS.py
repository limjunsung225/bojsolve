import sys
input= sys.stdin.readline

def lcs(li1, li2):
    l1 = len(li1)
    l2 = len(li2)

    dp = [[0] * (l1 + 1) for _ in range(l2 + 1)]

    for i in range(1, l2 + 1):
        C = li2[i - 1]
        for j in range(1, l1 + 1):
            if C == li1[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])

    return dp[l2][l1]


li1 = input().rstrip()
li2 = input().rstrip()

print(lcs(li1, li2))