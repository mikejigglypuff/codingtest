import sys
input = sys.stdin.readline

def bfs(x):
  next = []
  if(len(x) == 0):
    return

  for i in x:
    for j in graph[i]:
      if not(visited[j]):
        next.append(j)
        visited[j] = True

  global result
  result += len(next)
  bfs(next)

n = int(input().rstrip())
m = int(input().rstrip())
graph = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
result = 0
for _ in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

visited[1] = True
bfs([1])
print(result)