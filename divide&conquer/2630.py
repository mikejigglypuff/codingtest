import sys

zero = 0
one = 0

def div(n, paper):
    half, target, result = n // 2, 0, [[], [], [], []]

    for i in range(n ** 2):
        width, height = i % n, i // n
        if(width < half):
            if(height >= half):
                target = 2
            else:
                target = 0
        else:
            if(height >= half):
                target = 3
            else:
                target = 1

        result[target].append(paper[i])

    return result


def div_con(n, paper):
    blue, white = 0, 0
    for i in range(n ** 2):
        if(paper[i] == 1):
            blue += 1
        else:
            white += 1

    if(blue == n ** 2):
        global one
        one += 1
        return

    if(white == n ** 2):
        global zero
        zero += 1
        return

    m = n // 2
    pieces = div(n, paper)
    div_con(m, pieces[0])
    div_con(m, pieces[1])
    div_con(m, pieces[2])
    div_con(m, pieces[3])

n = int(sys.stdin.readline())
paper = []
for i in range(n):
    input = list(map(int, sys.stdin.readline().split()))
    paper = paper + input

div_con(n, paper)
print(zero)
print(one)