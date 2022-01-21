import sys

n = int(sys.stdin.readline())
paper = []
for i in range(n):
   input = list(map(int, sys.stdin.readline().split()))
   paper.append(input)

result = [0, 0, 0]

def check(x, y, n):
    num = paper[x][y]
    for i in range(n):
        for j in range(n):
            if(paper[x + i][y + j] != num):
                return False
    return True

def div_con(x, y, n):
    if(check(x, y, n)):
        result[paper[x][y] + 1] += 1
    else:
        m = n // 3
        for i in range(3):
            for j in range(3):
                div_con(x + (i * m), y + (j * m), m)
    

div_con(0, 0, n)

for i in range(3):
    print(result[i])

# https://suri78.tistory.com/69 를 참고하였음