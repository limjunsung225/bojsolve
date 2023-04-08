T = int(input())

for _ in range(T):
    N = int(input())
    temp = 0
    for i in range(N):
        item , n , price = map(str,input().split())
        n = int(n)
        price = float(price)
        temp += price * n
    print("${:.2f}".format(round(temp,2)))