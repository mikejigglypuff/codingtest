import sys
import math

cur = 100
max_input = 500000
button_min = 500000
len_button = 10
channel = 0
buttons = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

def remocon(n, digit):
  global button_min
  if(digit > math.log10(max_input) + 1):
    return
  nums_count = len_button ** digit

  for i in range(nums_count):
    comp = 0
    x = i
    for j in range(digit):
      comp += (10 ** j) * buttons[x % len_button]
      x = x // len_button
    diff = abs(n - comp)
    global channel
    if(button_min > diff):
      button_min = diff
      channel = comp
  remocon(n, digit + 1)

n = int(sys.stdin.readline().rstrip())
brokes = []
m = int(sys.stdin.readline().rstrip())
if(m > 0):
  brokes = list(map(int, sys.stdin.readline().split()))

for i in brokes:
  buttons.remove(i)
len_button -= m

remocon(n, 1)

if(channel != 0):
  print(min(math.floor(math.log10(channel)) + 1 + button_min, abs(n - cur)))
else:
  print(min(button_min + 1, abs(n - cur)))