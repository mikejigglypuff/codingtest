import sys
input = sys.stdin.readline

def search():
  depth = 1
  queue = [[0, 0]]
  
  while(queue):
    l = len(queue)

    next = []
    for i in range(l):
      cur = queue[i]
      x, y = cur[0], cur[1]
      

      if(x == m - 1 and y == n - 1):
        global min
        if(min > depth):
          min = depth
          return

      if(x > 0 and not visited[y][x - 1] and maze[y][x - 1] == '1'):
        next.append([x - 1, y])
        visited[y][x - 1] = True
      if(x < m - 1 and not visited[y][x + 1] and maze[y][x + 1] == '1'):
        next.append([x + 1, y])
        visited[y][x + 1] = True
      if(y > 0 and not visited[y - 1][x] and maze[y - 1][x] == '1'):
        next.append([x, y - 1])
        visited[y - 1][x] = True
      if(y < n - 1 and not visited[y + 1][x] and maze[y + 1][x] == '1'):
        next.append([x, y + 1])
        visited[y + 1][x] = True

    depth += 1
    queue = next

n, m = map(int, input().split())
maze, visited = [], [[False for _ in range(m)] for _ in range(n)]

for _ in range(n):
  maze.append(input().rstrip())

visited[0][0] = True
min = n * m
      
search()
print(min)