import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
min, minnum = 500000, 101

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False] * (n + 1)

def bfs(start, nodes, depth, bacon):
    global min, minnum
    if(len(nodes) == 0):
        if(bacon < min):
            min = bacon
            minnum = start
        elif(bacon == min and start < minnum):
            minnum = start
        return
    
    for i in nodes:
        if not(visited[i]):
            visited[i] = True
            bacon += depth

    next = []
    for i in nodes:
        for j in graph[i]:
            if not(visited[j]):
                next.append(j)
    
    bfs(start, next, depth + 1, bacon)

for i in range(1, n + 1):
    bfs(i, [i], 0, 0)
    visited = [False] * (n + 1)

print(minnum)