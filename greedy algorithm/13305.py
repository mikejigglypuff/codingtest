import sys

n = int(sys.stdin.readline().rstrip())
distance = list(map(int, sys.stdin.readline().rstrip().split()))
price = list(map(int, sys.stdin.readline().rstrip().split()))
result, dis, min = 0, 0, price[0]

for i in range(1, n):
    if(price[i] > min):
        dis += distance[i - 1]
    else:
        result += min * (dis + distance[i - 1])
        min, dis = price[i], 0
if(dis != 0):
    result += min * dis

print(result)