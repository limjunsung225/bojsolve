import sys
input =sys.stdin.readline

T = int(input())
for tc in range(T):
    N = int(input())
    word = list(map(str,input().rstrip().split()))
    ans = ""
    ans += word[0]
    word = word[1:]

    for i in word:
        if len(ans) == 1:
            if ord(ans) > ord(i):
                ans = i + ans
            elif ord(ans[0]) == ord(i):
                ans = i+ans
            else:
                ans += i 
        else:
            if ord(ans[0]) > ord(i):
                ans = i+ans
            elif ord(ans[0]) == ord(i):
                ans = i+ans
            else:
                ans += i
    print(ans)