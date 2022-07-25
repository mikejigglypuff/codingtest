import sys
input = sys.stdin.readline

pokemons = {}

n, m = map(int, input().split())
for i in range(n):
    pokemon = input().rstrip()
    pokemons[pokemon] = i + 1

reversed_pokemons = dict(map(reversed, pokemons.items()))
result = ""

for j in range(m):
    prob = input().rstrip()
    try:
        prob = int(prob)
        result += reversed_pokemons[prob]
    except:
        result += str(pokemons[prob])
    if(j < m - 1):
        result += "\n"

print(result)