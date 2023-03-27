import sys
input = sys.stdin.readline

S = list(input().rstrip())
w = list(input().rstrip())

stack = []

for i in range(len(S)):
    stack.append(S[i])
    if stack[-1] == w[-1] and len(stack) >= len(w):
        if stack[-len(w):] == w:
            for j in range(len(w)):
                stack.pop()

if len(stack)!=0:
    print("".join(map(str,stack)))
else:
    print("FRULA")