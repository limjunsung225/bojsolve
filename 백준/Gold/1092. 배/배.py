import sys

input = sys.stdin.readline

box = []

n= int(input())

crain = sorted(list(map(int,input().split())))

m= int(input())

box =(sorted(list(map(int,input().split()))))

crain.reverse()
box.reverse()

if box[0] > crain[0]:  #들수있는게 없으면 -1출력후 종료 
    print(-1)
    exit()

time = 0

while len(box) > 0: #박스가 전부 옮겨질때까지 

    time += 1

    # 크레인을 돌면서 박스를 옮긴다. 
    for i in crain:

        for j in range(len(box)):

            if i >= box[j]: #옮길수 있다면 

                del box[j]  #그 박스를 지운다. 

                break # 그 다음 crain으로 돌아간다. 

print(time)