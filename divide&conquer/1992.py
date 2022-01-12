import sys

comstr = ""

def div(n, paper):
    half, target, result = n // 2, 0, ["", "", "", ""]

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

        result[target] += paper[i]

    return result


def quadtree(n, paper):
    global comstr
    black, white = 0, 0
    for i in range(n ** 2):
        if(paper[i] == "1"):
            black += 1
        else:
            white += 1

    if(black == n ** 2):
        comstr += "1"
        return

    if(white == n ** 2):
        comstr += "0"
        return

    m = n // 2
    pieces = div(n, paper)
    comstr += "("
    quadtree(m, pieces[0])
    quadtree(m, pieces[1])
    quadtree(m, pieces[2])
    quadtree(m, pieces[3])
    comstr += ")"

n = int(sys.stdin.readline())
paper = ""
for i in range(n):
    input = sys.stdin.readline().rstrip()
    paper += input

print(paper)
quadtree(n, paper)
print(comstr)