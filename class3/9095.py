import sys
input = sys.stdin.readline

sums = ["0", ["1"]]
for i in range(2, 11):
  s = {}
  for j in range(1, i):
    if(i <= 3):
      s[str(i)] = 1
    n = i - j
    if(n <= 3 and j <= 3):
      s[str(j) + str(n)] = 1
    li, ln = len(sums[j]), len(sums[n])
    for k in range(li):
      for l in range(ln):
        adds = sums[j][k] + sums[n][l]
        try:
          s[adds] += 1         
        except:
          s[adds] = 1
  sums.append(list(s.keys()))
      
for _ in range(int(input().rstrip())):
    print(len(sums[int(input().rstrip())]))