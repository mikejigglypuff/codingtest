import sys, heapq
input = sys.stdin.readline

h = []

n = int(input().rstrip())
result = ""
for _ in range(n):
  oper = int(input().rstrip())
  if(oper == 0):
    if(len(h) != 0):
      result += "\n" + str(-heapq.heappop(h)) 
    else:
      result += "\n0"
  else:
    heapq.heappush(h, -oper)

if(result != ""):
  print(result.lstrip())