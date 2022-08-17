import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
result = 0

for _ in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

for i in range(1, n + 1):
  if(visited[i]):
    continue
  
  visited[i] = True
  queue = graph[i]
  while(queue):
    next = []
    for j in queue:
      if not(visited[j]):
        visited[j] = True
        next += graph[j]
    queue = next
  result += 1

print(result)