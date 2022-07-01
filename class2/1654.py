import math, sys

cables = []

def lancable():
    start, end = 1, 2 ** 31
    mid = int(math.sqrt(start * end))
    while(end - start > 2): #sqrt(x * (x + 2)) // 1 == x
        if(lennum(mid) >= n):
            start = mid
            mid = int(math.sqrt(start * end))
        else:
            end = mid
            mid = int(math.sqrt(start * end))

    mid = end
    while(mid > start):
        if(lennum(mid) >= n):
            return mid
        else:
            mid -= 1

    return mid

def lennum(mid):
    global cables
    global k
    result = 0
    for i in range(k):
        result += cables[i] // mid
    return result

k, n = map(int, sys.stdin.readline().split())

for i in range(k):
    input = int(sys.stdin.readline().rstrip())
    cables.append(input)

print(lancable())