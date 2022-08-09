import sys
input = sys.stdin.readline

def ripened():
  result = []
  for i in range(n):
    for j in range(m):
      if(tomatos[i][j] == 1 and not visited[i][j]):
        result.append([i, j])
        visited[i][j] = True
  return result

'''
재귀를 이용한 방식
def ripen(day, rtomatos):
  if(len(rtomatos) == 0):
    global days
    days = day if(completed()) else -1
    return
  
  next = []
  for i in rtomatos:
    x, y = i[1], i[0]
    
    if(x > 0 and tomatos[y][x - 1] == 0 and not visited[y][x - 1]):
      tomatos[y][x - 1] = 1
      visited[y][x - 1] = True
      next.append([y, x - 1])
    if(x < m - 1 and tomatos[y][x + 1] == 0 and not visited[y][x + 1]):
      tomatos[y][x + 1] = 1
      visited[y][x + 1] = True
      next.append([y, x + 1])
    if(y > 0 and tomatos[y - 1][x] == 0 and not visited[y - 1][x]):
      tomatos[y - 1][x] = 1
      visited[y - 1][x] = True
      next.append([y - 1, x])
    if(y < n - 1 and tomatos[y + 1][x] == 0 and not visited[y + 1][x]):
      tomatos[y + 1][x] = 1
      visited[y + 1][x] = True
      next.append([y + 1, x])

  ripen(day + 1, next)
'''

def ripen(rtomatos):
  day = -1
  next = []
  while(len(rtomatos) != 0):
    for i in rtomatos:
      x, y = i[1], i[0]

      if(x > 0 and tomatos[y][x - 1] == 0 and not visited[y][x - 1]):
        tomatos[y][x - 1] = 1
        visited[y][x - 1] = True
        next.append([y, x - 1])
      if(x < m - 1 and tomatos[y][x + 1] == 0 and not visited[y][x + 1]):
        tomatos[y][x + 1] = 1
        visited[y][x + 1] = True
        next.append([y, x + 1])
      if(y > 0 and tomatos[y - 1][x] == 0 and not visited[y - 1][x]):
        tomatos[y - 1][x] = 1
        visited[y - 1][x] = True
        next.append([y - 1, x])
      if(y < n - 1 and tomatos[y + 1][x] == 0 and not visited[y + 1][x]):
        tomatos[y + 1][x] = 1
        visited[y + 1][x] = True
        next.append([y + 1, x])
    rtomatos = next[:]
    next.clear()
    day += 1
  
  global days
  days = day if(completed()) else -1

def completed():
  for i in range(n):
    for j in range(m):
      if(tomatos[i][j] == 0):
        return False
  return True

m, n = map(int, input().split())
tomatos = []
visited = [[False for _ in range(m)] for _ in range(n)]
for i in range(n):
  lines = list(map(int, input().split()))
  tomatos.append(lines)

days = 0
ripen(ripened())
print(days)