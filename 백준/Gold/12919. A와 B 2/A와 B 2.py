import sys
input = sys.stdin.readline

S = input().rstrip()
T = input().rstrip()

def dfs(temp):

    if temp == S: #만들어지면 1 리턴
        return 1
    
    if len(temp)<=len(S): # 만들 수 없으면 0 리턴
        return 0

    result = 0

    if temp[-1] == 'A': #맨뒤가 1이면 A면 하나 제거하면 되고
        result = dfs(temp[:-1])
    
    if result == 1:
        return 1

    if temp[0] == 'B': # 맨앞이 B면 뒤집고 재귀
        temp = temp[::-1]
        result = dfs(temp[:-1])

    return result

print(dfs(T))