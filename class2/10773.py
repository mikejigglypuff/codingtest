import sys

def arr_sum(arr):
  sum = 0
  l = len(arr)
  for i in range(l):
    sum += arr[i]
  return sum

n = int(sys.stdin.readline().rstrip())
arr = []
for i in range(n):
  input = int(sys.stdin.readline().rstrip())
  if(input != 0):
    arr.append(input)
  else:
    arr.pop()

print(arr_sum(arr))