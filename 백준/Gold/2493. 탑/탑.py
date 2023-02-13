import sys
input= sys.stdin.readline

N= int(input())
li= list(map(int,input().split()))
stack = []
answer= [0] * len(li)
li.reverse()

for i in range(len(li)):
    if len(stack) == 0:
        stack.append((len(li)-i-1,li[i]))
        continue
    elif len(stack) != 0:
        if li[i] > stack[-1][1]:
            while True:
                if len(stack)==0:
                    stack.append((len(li)-i-1,li[i]))
                    break
                
                if li[i] > stack[-1][1]:
                    answer[stack[-1][0]]= len(li)-i
                    stack.pop(-1)

                
                elif li[i] <= stack[-1][1]:
                    stack.append((len(li)-i-1,li[i]))
                    break
        else:
            stack.append((len(li)-i-1,li[i]))

print(*answer)
