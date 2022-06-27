import sys

def merge_sort(n, ncard):
  if(n <= 1):
    return ncard
  
  x = n // 2
  y = len(ncard) - x
  div1 = merge_sort(x, ncard[:x])
  div2 = merge_sort(y, ncard[x:])

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

def makedict(n, ncard):
    dict = {}
    prev = ncard[0]
    dict[prev] = 1

    for i in range(1, n):
        if(ncard[i] == prev):
            dict[prev] += 1
        else:
            prev = ncard[i]
            dict[prev] = 1

    return dict



n = int(input())
ncard = list(map(int, sys.stdin.readline().split()))
m = int(input())
nums = list(map(int, sys.stdin.readline().split()))

sorted_ncard = merge_sort(n, ncard)
ncard_dict = makedict(n, sorted_ncard)


for i in range(m):
    try:
        nums[i] = ncard_dict[nums[i]]
    except:
        nums[i] = 0

print(*nums)