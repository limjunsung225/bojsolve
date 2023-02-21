import sys
import copy

sys.setrecursionlimit(10**7)

n=int(input())

graph = []

for i in range(n):

    graph.append(list(map(str,input().strip())))


graph2 =copy.deepcopy(graph)

for i in range(n):

    for j in range(n):

        if graph2[i][j] =="R":

            graph2[i][j] ="G"


def dfs_r(x,y):

    if x<=-1 or x>=n or y<=-1 or y>=n:

        return False
    

    if graph[x][y] =="R":
        
        graph[x][y] = "X"
        dfs_r(x,y-1)
        dfs_r(x,y+1)
        dfs_r(x-1,y)
        dfs_r(x+1,y)

        return False
    
    return True

def dfs_g(x,y):

    if x<=-1 or x>=n or y<=-1 or y>=n:

        return False
    

    if graph[x][y] =="G":
        
        graph[x][y] = "X"
        dfs_g(x,y-1)
        dfs_g(x,y+1)
        dfs_g(x-1,y)
        dfs_g(x+1,y)

        return False
    
    return True

def dfs_b(x,y):

    if x<=-1 or x>=n or y<=-1 or y>=n:

        return False
    

    if graph[x][y] =="B":
        
        graph[x][y] = "X"
        dfs_b(x,y-1)
        dfs_b(x,y+1)
        dfs_b(x-1,y)
        dfs_b(x+1,y)

        return False
    
    return True

def dfs_g2(x,y):

    if x<=-1 or x>=n or y<=-1 or y>=n:

        return False
    

    if graph2[x][y] =="G":
        
        graph2[x][y] = "X"
        dfs_g2(x,y-1)
        dfs_g2(x,y+1)
        dfs_g2(x-1,y)
        dfs_g2(x+1,y)

        return False
    
    return True

def dfs_b2(x,y):

    if x<=-1 or x>=n or y<=-1 or y>=n:

        return False
    

    if graph2[x][y] =="B":
        
        graph2[x][y] = "X"
        dfs_b2(x,y-1)
        dfs_b2(x,y+1)
        dfs_b2(x-1,y)
        dfs_b2(x+1,y)

        return False
    
    return True

result1= 0
result2= 0

for i in range(n):

    for j in range(n):

        if dfs_r(i,j) != True:

            result1+=1

        elif dfs_g(i,j) != True:

            result1+=1

        elif dfs_b(i,j) != True:

            result1+=1  

for i in range(n):

    for j in range(n):


        if dfs_g2(i,j) != True:

            result2+=1  

        elif dfs_b2(i,j) != True:

            result2+=1  


print("{} {}".format(result1,result2))

