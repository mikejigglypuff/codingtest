import sys

def merge_sort(n, arr):
  if(n <= 1):
    return arr
  
  x = n // 2
  y = len(arr) - x
  div1 = merge_sort(x, arr[:x])
  div2 = merge_sort(y, arr[x:])

  return merge(div1, div2, x, y)

def merge(div1, div2, len1, len2):
  i, j = 0, 0
  result = []

  while(i < len1 and j < len2):
    if(div1[i] <= div2[j]):
      result.append(div1[i])
      i += 1
    else:
      result.append(div2[j])
      j += 1

  while(i < len1):
    result.append(div1[i])
    i += 1
  while(j < len2):
    result.append(div2[j])
    j += 1

  return result

def tree_binary_search(n, m, trees):
  start, end = 0, trees[n - 1]
  mid = (start + end) // 2
  while(mid != start and mid != end):
    sum = 0
    for i in range(n - 1, -1, -1):
      if(trees[i] > mid):
        sum += trees[i] - mid
    if(sum >= m):
      start = mid
    else:
      end = mid
    mid = (start + end) // 2
  return mid
            

n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))
trees = merge_sort(n, trees)
print(tree_binary_search(n, m, trees))