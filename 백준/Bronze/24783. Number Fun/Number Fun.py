import sys
input =sys.stdin.readline

N = int(input())
for _ in range(N):
    a, b , c = map(int,input().split())

    if (a+b)== c or (a*b)== c or (a/b)==c or (a-b)==c or (b-a)==c or (b/a)== c:
        print("Possible")
    else:
        print("Impossible")