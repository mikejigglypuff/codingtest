from re import X
import sys

mintime, maxfloor = 128 * (10 ** 6), 0

def till_ground():
  global n, m, b, mintime, maxfloor, blocks
  floor, time, sum = 0, 128 * (10 ** 6), 0
  while(True):
    time, sum = 0, 0

    for i in range(n):
      for j in range(m):
        x = blocks[i][j] - floor
        sum += x
        if(x > 0):
          time += x * 2
        else:
          time += abs(x)

    if(sum + b >= 0):
      if(time < mintime):
        mintime = time
        maxfloor = floor
      elif(time == mintime):
        if(floor > maxfloor):
          maxfloor = floor
    else:
      break

    floor += 1


n, m, b = map(int, sys.stdin.readline().split())
blocks = []
for i in range(n):
  input = list(map(int, sys.stdin.readline().split()))
  blocks.append(input)


till_ground()
print(mintime, maxfloor)