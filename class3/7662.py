import sys, heapq
input = sys.stdin.readline

'''
https://hae-sooo97.tistory.com/54를 참고
두 힙들의 동기화 방식에 대한 연습이 필요할 것
'''

class Dual_heap():
  def __init__(self):
    self.minheap, self.maxheap = [], []
    self.removed = [False for _ in range(1000001)]
    self.id = 0

  def input(self, n):
    heapq.heappush(self.minheap, [n, self.id])
    heapq.heappush(self.maxheap, [-n, self.id])
    self.removed[self.id] = True
    self.id += 1
  
  def del_front(self):
    while self.minheap and not self.removed[self.minheap[0][1]]:
      heapq.heappop(self.minheap)

    if self.minheap:
      self.removed[self.minheap[0][1]] = False 
      heapq.heappop(self.minheap)
      

  def del_back(self):
    while self.maxheap and not self.removed[self.maxheap[0][1]]:
      heapq.heappop(self.maxheap)

    if self.maxheap:
      self.removed[self.maxheap[0][1]] = False 
      heapq.heappop(self.maxheap)

  def print_minmax(self):
    while self.minheap and not self.removed[self.minheap[0][1]]:
      heapq.heappop(self.minheap)
    while self.maxheap and not self.removed[self.maxheap[0][1]]:
      heapq.heappop(self.maxheap)

    global printbuf
    if(printbuf != ""):
      printbuf += "\n"
    if self.minheap:
      printbuf += str(-self.maxheap[0][0]) + " " + str(self.minheap[0][0])
    else:
      printbuf += "EMPTY"

printbuf = ""
t = int(input().rstrip())
for _ in range(t):
  k = int(input().rstrip())
  dualheap = Dual_heap()
  for _ in range(k):
    command, num = map(str, input().split())
    if(command == 'I'):
      dualheap.input(int(num))
    elif(command == 'D'):
      if(num == '1'):
        dualheap.del_back()
      elif(num == '-1'):
        dualheap.del_front()
  dualheap.print_minmax()
print(printbuf)  