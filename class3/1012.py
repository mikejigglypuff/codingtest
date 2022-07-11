import sys

cabbages = []
loc = []

def get_min_worm(m, n):
  global cabbages, loc
  result = 0

  for i in loc:
    if(i[0] < 0 or i[0] > m - 1 or i[1] < 0 or i[1] > n - 1 or cabbages[i[0]][i[1]] == 0):
      continue
    
    queue = []
    queue.append(i)
    left, right, up, down = 1, 1, 1, 1
    while(len(queue) != 0):
      pos = queue.pop()
      x, y = pos[0], pos[1]
      if(x >= 0 and x <= m - 1 and y >= 0 and y <= n - 1 and cabbages[x][y] == 1):
        cabbages[x][y] = 0

        if(x > 0):
          left = cabbages[x - 1][y]
        else:
          left = 0
        if(x < m - 1):
          right = cabbages[x + 1][y]
        else:
          right = 0
        if(y > 0):
          up = cabbages[x][y - 1]
        else:
          up = 0
        if(y < n - 1):
          down = cabbages[x][y + 1]
        else:
          down = 0

        if(left == 1):
          queue.append([x - 1, y])
        if(right == 1):
          queue.append([x + 1, y])
        if(up == 1):
          queue.append([x, y - 1])
        if(down == 1):
          queue.append([x, y + 1])
      
    result += 1
  return result


t = int(sys.stdin.readline().rstrip())
for i in range(t):
  m, n, k = map(int, sys.stdin.readline().split())
  cabbages = [[0 for k in range(n)] for l in range(m)]
  for j in range(k):
    x, y = map(int, sys.stdin.readline().split())
    loc.append([x, y])
    cabbages[x][y] = 1
  print(get_min_worm(m, n))