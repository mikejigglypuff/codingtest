import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nohear = {}
noseehear = []
for i in range(n):
  name = input().rstrip()
  nohear[name] = 1

for i in range(m):
  name = input().rstrip()
  try:
    if(nohear[name]):
      noseehear.append(name)
  except:
    continue

noseehear.sort()
prints = str(len(noseehear))
for i in noseehear:
  prints += "\n" + i

print(prints)