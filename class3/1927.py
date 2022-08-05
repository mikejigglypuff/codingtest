import sys, heapq
input = sys.stdin.readline

h = []

n = int(input().rstrip())
result = ""
for i in range(n):
  oper = int(input().rstrip())
  if(oper == 0):
    if(len(h) != 0):
      result += "\n" + str(heapq.heappop(h)) 
    else:
      result += "\n0"
  else:
    heapq.heappush(h, oper)

if(result != ""):
  print(result.lstrip())

"""
직접 큐를 구현한 방식
import sys
input = sys.stdin.readline

class Min_heap:
  def __init__(self):
    self.heap = []
    self.len = 0
  
  def add(self, n):
    self.len += 1
    self.heap.append(n)
    x = self.len - 1
    while(x > 0):
      y = (x - 1) // 2
      if(self.heap[x] < self.heap[y]):
        self.heap[x], self.heap[y] = self.heap[y], self.heap[x]
        x = y
      else:
        break
  
  def remove(self):
    if(self.len <= 0):
      return 0
    
    x = self.len - 1
    self.heap[x], self.heap[0] = self.heap[0], self.heap[x]
    result = self.heap.pop(x)
    self.len -= 1
    pointer = 1
    while(pointer * 2 - 1 < x):
      child = pointer * 2
      child2 = min(child + 1, x - 1)
      target = child if(self.heap[child - 1] < self.heap[child2 - 1]) else child2
      if(self.heap[pointer - 1] > self.heap[target - 1]):
        self.heap[pointer - 1], self.heap[target - 1] = self.heap[target - 1], self.heap[pointer - 1]
        pointer = target
      else:
        break
    return result

  def printheap(self):
    print(self.heap)

heap = Min_heap()
n = int(input().rstrip())
result = ""
for i in range(n):
  oper = int(input().rstrip())
  if(oper == 0):
    result += "\n" + str(heap.remove()) 
  else:
    heap.add(oper)

if(result != ""):
  print(result.lstrip())
"""