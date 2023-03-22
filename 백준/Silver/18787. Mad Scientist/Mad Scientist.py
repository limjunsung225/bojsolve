import sys
input= sys.stdin.readline

N = int(input())
A = input().rstrip()
B = input().rstrip()

res = 0
flag = False

for i in range(len(B)):
    if flag==True or A[i] !=B[i]:
        flag = True
    if flag == True and A[i] == B[i]:
        res += 1
        flag = False
print("{}".format(res))