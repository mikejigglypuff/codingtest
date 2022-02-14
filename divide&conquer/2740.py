import sys

a, b = [], []
n, m = map(int, sys.stdin.readline().split())
for i in range(n):
    input = list(map(int, sys.stdin.readline().split()))
    a.append(input)

m, k = map(int, sys.stdin.readline().split())
for i in range(m):
    input = list(map(int, sys.stdin.readline().split()))
    b.append(input)

result = [[0 for i in range(k)] for j in range(n)]
for i in range(n):
    for j in range(k):
        for x in range(m):
           result[i][j] += a[i][x] * b[x][j]

for y in range(n):
    printstr = ""
    for z in range(k - 1):
        printstr += str(result[y][z]) + " "
    printstr += str(result[y][k - 1])
    print(printstr)