import sys
input = sys.stdin.readline

n = int(input().rstrip())
people = sorted(list(map(int, input().split())))

sum, result = 0, 0
for i in people:
  sum += i
  result += sum
print(result)