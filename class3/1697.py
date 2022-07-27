import sys
from collections import deque
input = sys.stdin.readline

def hide_and_seek(n):
  depth = 1
  min = abs(k - n)
  queue = deque([n - 1, n + 1, n * 2])
  temp_queue = deque([])
  while(True):
    if(depth >= min):
      return depth
    temp_queue.clear()
    while(queue):
      cur = queue.popleft()
      if(cur == k):
        return depth
      if(cur > k):
        min = depth + cur - k if (cur - k < min - depth) else min
      elif(cur >= 0):
        plus, minus, mul = cur + 1, cur - 1, cur * 2
        if(minus > 0 and not visited[minus]):
          temp_queue.append(minus)
          visited[minus] = True
        if(mul <= k and not visited[mul]):
          temp_queue.append(mul)
          visited[mul] = True
        elif(mul > k):
          temp_queue.append(mul)
        if(plus <= k and not visited[plus]):
          temp_queue.append(plus)
          visited[plus] = True
    queue = temp_queue.copy()
    if(len(queue) == 0):
      return depth
    depth += 1
    

n, k = map(int, input().split())
visited = [False for _ in range(k + 1)]
if(n < k):
  visited[n] = True
  print(hide_and_seek(n))
else:
  print(n - k)