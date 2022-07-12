import sys
import math

def Z(n, r, c):
  width, divs, result = math.sqrt(n), n // 4, 0
  div_width = width // 2
  x, y = 0, 0
  while(width > 1):
    if(c >= x + div_width):
      x += div_width
      result += divs
    if(r >= y + div_width):
      y += div_width
      result += divs * 2

    width, divs, div_width = width // 2, divs // 4, div_width // 2
  
  return result

n, r, c = map(int, sys.stdin.readline().split())
print(Z((2 ** n) ** 2, r, c))