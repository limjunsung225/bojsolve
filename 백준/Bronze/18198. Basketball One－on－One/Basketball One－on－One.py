import sys
input= sys.stdin.readline

word = input().rstrip()
a = 0
b = 0

for i in range(len(word)):
    if word[i] == "A":
        a += int(word[i+1])
    if word[i] == "B":
        b += int(word[i+1])

if a>b:
    print("A")
else:
    print("B")