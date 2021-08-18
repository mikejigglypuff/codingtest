import sys

def w(a, b, c):
  result = 0
  if(a == 0 or b == 0 or c == 0):
    result = 1
  elif(a < b and b < c):
    result = abcw[a][b][c - 1] + abcw[a][b - 1][c - 1] - abcw[a][b - 1][c]
  elif(a == b and b == c):
    result = 2 ** a
  else:
    result = abcw[a - 1][b][c] + abcw[a - 1][b - 1][c] + abcw[a - 1][b][c - 1] - abcw[a - 1][b - 1][c - 1]
  abcw[a][b][c] = result
  return

abcw = [[[1 for i in range(21)] for j in range(21)] for k in range(21)]

for l in range(21 ** 3):
  w(l // (21 ** 2), (l % (21 ** 2)) // 21, l % 21)

while True:
  a, b, c = map(int, sys.stdin.readline().rstrip().split())
  if(a == -1 and b == -1 and c == -1):
    break
  elif(a <= 0 or b <= 0 or c <= 0):
    print("w({}, {}, {}) = {}".format(a, b, c, 1))
  elif(a > 20 or b > 20 or c > 20):
    print("w({}, {}, {}) = {}".format(a, b, c, abcw[20][20][20]))
  else:
    print("w({}, {}, {}) = {}".format(a, b, c, abcw[a][b][c]))
