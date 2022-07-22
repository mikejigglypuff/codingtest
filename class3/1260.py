#https://www.devchopin.com/blog/96/를 참고
import sys
from collections import deque
input=sys.stdin.readline

n,m,start=map(int,input().split())
visited=[False]*(n+1)

graph=[[] for _ in range(n+1)]

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(len(graph)):
    graph[i].sort()

def dfs(start):
    print(start,end=' ')
    visited[start]=True
    for i in graph[start]:
        if not visited[i]:
            dfs(i)
            visited[i]=True

def bfs(start):
    q=deque([start])
    visited[start]=True
    while q:
        now=q.popleft()
        print(now,end=' ')
        for i in graph[now]:
            if not visited[i]:
                q.append(i)
                visited[i]=True
dfs(start)
visited=[False]*(n+1)
print()
bfs(start)

"""
나의 틀린 풀이
import sys

dfsbuf = []
bfsbuf = []

def dfs(v):
  if(v in dfsbuf or v <= 0 or v > n):
    return
  
  removed = []
  for i in NUMS[v]:
    if(i not in dfsbuf):
      removed.append(i)
  l = len(removed)
  
  dfsbuf.append(v)

  if(l == 0):
    return

  for i in removed:
    dfs(i)

def bfs(v):
  removed = []
  for i in v:
    if(i > 0 and i <= n and i not in bfsbuf):
      removed.append(i)
      bfsbuf.append(i)
  l, v = len(removed), removed

  if(l == 0):
    return
  
  childs = []
  for i in range(l):
    removed_nums = []
    for j in NUMS[v[i]]:     
      if(j not in bfsbuf):
        removed_nums.append(j)
    childs += removed_nums
  bfs(childs)

n, m, v = map(int, sys.stdin.readline().split())
NUMS = [[] for i in range(n + 1)]
for i in range(m):
  index, adds = map(int, sys.stdin.readline().split())
  NUMS[index].append(adds)
  NUMS[adds].append(index)

for i in range(len(NUMS)):
    NUMS[i].sort()

dfs(v)
bfs([v])
dfsprint, bfsprint = "", ""
buflen = len(dfsbuf)
for i in range(buflen):
  dfsprint += str(dfsbuf[i])
  if(i != buflen - 1):
    dfsprint += " " 

for i in range(buflen):
  bfsprint += str(bfsbuf[i])
  if(i != buflen - 1):
    bfsprint += " " 

print(dfsprint + "\n" + bfsprint)
"""