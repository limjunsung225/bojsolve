import sys
input =sys.stdin.readline
N = int(input())
P = int(input())
li = [0]	

if N >= 5 :
    li.append(500)	
if N >= 10 :
    li.append(P // 10)	
if N >= 15 :
    li.append(2000)	
if N >= 20 :
    li.append(P // 4)	

result = P - max(li)
if result < 0 :	
    result = 0	
print(result)