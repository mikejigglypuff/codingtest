import sys
input = sys.stdin.readline

set = 0
n = int(input().rstrip())
num = 0

for _ in range(n):
  x = list(map(str, input().split()))
  if(x[0] == "add"):
    num = 1 << int(x[1])
    if(set & num == 0):
      set += num
  elif(x[0] == "remove"):
    num = 1 << int(x[1])
    if(set & num == num):
      set -= num  
  elif(x[0] == "check"):
    num = 1 << int(x[1])
    if(set & num == num):
      print(1)
    else:
      print(0)
  elif(x[0] == "toggle"):
    num = 1 << int(x[1])
    if(set & num == 0):
      set += num
    elif(set & num == num):
      set -= num 
  elif(x[0] == "all"):
    set = (1 << 21) - 1
  elif(x[0] == "empty"):
    set = 0