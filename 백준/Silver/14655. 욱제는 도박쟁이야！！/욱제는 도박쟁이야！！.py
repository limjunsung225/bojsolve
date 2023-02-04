import sys
input= sys.stdin.readline

N = int(input())
li1=  list(map(int,input().split()))
li2=  list(map(int,input().split()))

num1 = 0
num2 = 0

for i in li1:
    num1 += abs(i)
for i in li2:
    num2 += abs(i)
print((num1)+(num2))