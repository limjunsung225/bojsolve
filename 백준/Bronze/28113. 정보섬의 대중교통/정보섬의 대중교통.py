N, A, B = map(int, input().split())

bus_time = A
subway_time = max(N,B)

if bus_time < subway_time:
    print("Bus")
elif bus_time > subway_time:
    print("Subway")
else:
    print("Anything")